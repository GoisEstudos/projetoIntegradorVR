CREATE TABLE cargo(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    nome VARCHAR(7),
    CONSTRAINT pk_cargo PRIMARY KEY(id)
);

CREATE TABLE tipoConta(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    nome VARCHAR(10),
    CONSTRAINT pk_tipoConta PRIMARY KEY(id)
);

CREATE TABLE tipoTransacao(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    nome VARCHAR(13) NOT NULL,
    CONSTRAINT pk_tipoTransacao PRIMARY KEY(id)
);

CREATE TABLE endereco (
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    cep VARCHAR(9) NOT NULL,
    logradouro VARCHAR(255) NOT NULL,
    localidade VARCHAR(255) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    CONSTRAINT pk_endereco PRIMARY KEY(id)
);

CREATE TABLE cliente(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    id_endereco UUID NOT NULL,
    CONSTRAINT pk_cliente PRIMARY KEY(id),
    CONSTRAINT fk_id_endereco_cliente FOREIGN KEY (id_endereco) REFERENCES endereco(id)
);

CREATE TABLE agencia (
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    numero VARCHAR(255) NOT NULL,
    id_endereco UUID NOT NULL,
    CONSTRAINT pk_agencia PRIMARY KEY(id),
    CONSTRAINT fk_id_endereco_agencia FOREIGN KEY (id_endereco) REFERENCES endereco(id)
);

CREATE TABLE funcionario(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    id_cargo UUID NOT NULL,
    id_agencia UUID NOT NULL,
    CONSTRAINT pk_funcionario PRIMARY KEY(id),
    CONSTRAINT fk_id_agencia_funcionario FOREIGN KEY (id_agencia) REFERENCES agencia(id),
    CONSTRAINT fk_id_cargo_funcionario FOREIGN KEY (id_cargo) REFERENCES cargo(id)
);

CREATE TABLE conta(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    numero VARCHAR(255) NOT NULL,
    saldo NUMERIC(12,2) NOT NULL,
    id_tipoConta UUID NOT NULL,
    id_cliente UUID NOT NULL,
    CONSTRAINT pk_conta PRIMARY KEY(id),
    CONSTRAINT fk_id_tipoConta_conta FOREIGN KEY (id_tipoConta) REFERENCES tipoConta(id),
    CONSTRAINT fk_id_cliente_conta FOREIGN KEY (id_cliente) REFERENCES cliente(id)
);

CREATE TABLE transacao(
    id UUID DEFAULT RANDOM_UUID() NOT NULL,
    data DATE NOT NULL,
    valor NUMERIC(12,2) NOT NULL,
    id_tipoTransacao UUID NOT NULL,
    id_conta UUID NOT NULL,
    CONSTRAINT pk_transacao PRIMARY KEY(id),
    CONSTRAINT fk_id_tipoTransacao FOREIGN KEY (id_tipoTransacao) REFERENCES tipoTransacao(id),
    CONSTRAINT fk_id_conta FOREIGN KEY (id_conta) REFERENCES conta(id)
);

INSERT INTO cargo(nome) VALUES
('GERENTE'),
('CAIXA');

INSERT INTO tipoConta(nome) VALUES
('CORRENTE'),
('POUPANCA');

INSERT INTO tipoTransacao(nome) VALUES
('DEPOSITO'),
('SAQUE'),
('TRANSFERENCIA');

INSERT INTO endereco (cep, logradouro, localidade, uf) VALUES
('13484-456', 'Rua Exemplo', 'Limeira', 'SP'),
('13484-457', 'Avenida Paulista', 'São Paulo', 'SP'),
('22041-001', 'Rua Atlântica', 'Rio de Janeiro', 'RJ'),
('30130-000', 'Praça da Liberdade', 'Belo Horizonte', 'MG'),
('40020-000', 'Avenida Sete de Setembro', 'Salvador', 'BA'),
('60060-110', 'Rua Floriano Peixoto', 'Fortaleza', 'CE'),
('80010-000', 'Rua XV de Novembro', 'Curitiba', 'PR'),
('88010-400', 'Rua Felipe Schmidt', 'Florianópolis', 'SC'),
('69005-070', 'Avenida Eduardo Ribeiro', 'Manaus', 'AM'),
('66017-000', 'Avenida Nazaré', 'Belém', 'PA'),
('70297-400', 'Avenida L2 Sul', 'Brasília', 'DF'),
('60165-070', 'Rua Vicente Leite', 'Fortaleza', 'CE'),
('29101-000', 'Avenida Jerônimo Monteiro', 'Vitória', 'ES'),
('64001-210', 'Avenida Frei Serafim', 'Teresina', 'PI'),
('50030-230', 'Avenida Guararapes', 'Recife', 'PE'),
('57020-900', 'Avenida Fernandes Lima', 'Maceió', 'AL'),
('29164-000', 'Avenida Central', 'Serra', 'ES'),
('89204-001', 'Rua João Colin', 'Joinville', 'SC'),
('50010-160', 'Rua do Sol', 'Recife', 'PE'),
('37550-000', 'Rua João de Souza', 'Itajubá', 'MG'),
('60425-000', 'Avenida Bezerra de Menezes', 'Fortaleza', 'CE');

INSERT INTO cliente (nome, cpf, id_endereco) VALUES
('João Silva', '123.456.789-00', (SELECT id FROM endereco WHERE cep = '13484-456')),
('Maria Oliveira', '987.654.321-00', (SELECT id FROM endereco WHERE cep = '13484-457')),
('Carlos Pereira', '111.222.333-44', (SELECT id FROM endereco WHERE cep = '22041-001')),
('Ana Souza', '555.666.777-88', (SELECT id FROM endereco WHERE cep = '30130-000')),
('Pedro Santos', '999.888.777-66', (SELECT id FROM endereco WHERE cep = '40020-000')),
('Mariana Costa', '444.333.222-11', (SELECT id FROM endereco WHERE cep = '60060-110')),
('Lucas Lima', '222.333.444-55', (SELECT id FROM endereco WHERE cep = '80010-000')),
('Fernanda Almeida', '666.777.888-99', (SELECT id FROM endereco WHERE cep = '88010-400')),
('Bruno Fernandes', '123.123.123-12', (SELECT id FROM endereco WHERE cep = '69005-070')),
('Clara Ribeiro', '321.321.321-23', (SELECT id FROM endereco WHERE cep = '66017-000')),
('Mateus Rocha', '987.987.987-98', (SELECT id FROM endereco WHERE cep = '70297-400')),
('Isabela Martins', '654.654.654-65', (SELECT id FROM endereco WHERE cep = '60165-070')),
('Rafael Mendes', '789.789.789-78', (SELECT id FROM endereco WHERE cep = '29101-000')),
('Beatriz Silva', '456.456.456-45', (SELECT id FROM endereco WHERE cep = '64001-210')),
('Eduardo Barros', '852.852.852-85', (SELECT id FROM endereco WHERE cep = '50030-230')),
('Larissa Cunha', '963.963.963-96', (SELECT id FROM endereco WHERE cep = '57020-900')),
('Renato Carvalho', '741.741.741-74', (SELECT id FROM endereco WHERE cep = '29164-000')),
('Juliana Freitas', '159.159.159-15', (SELECT id FROM endereco WHERE cep = '89204-001')),
('Gabriel Teixeira', '357.357.357-35', (SELECT id FROM endereco WHERE cep = '50010-160')),
('Camila Andrade', '753.753.753-57', (SELECT id FROM endereco WHERE cep = '37550-000'));