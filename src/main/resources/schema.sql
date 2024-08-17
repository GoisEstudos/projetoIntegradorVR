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
    cep VARCHAR(9) NOT NULL UNIQUE,
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
    nome VARCHAR(255) NOT NULL,
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
    CONSTRAINT pk_transacao PRIMARY KEY(id),
    CONSTRAINT fk_id_id_tipoTransacao FOREIGN KEY (id_tipoTransacao) REFERENCES tipoTransacao(id)
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
('01000-000', 'Rua A', 'São Paulo', 'SP'),
('02000-000', 'Rua B', 'São Paulo', 'SP'),
('03000-000', 'Rua C', 'São Paulo', 'SP'),
('04000-000', 'Rua D', 'São Paulo', 'SP'),
('05000-000', 'Rua E', 'São Paulo', 'SP'),
('06000-000', 'Rua F', 'São Paulo', 'SP'),
('07000-000', 'Rua G', 'São Paulo', 'SP'),
('08000-000', 'Rua H', 'São Paulo', 'SP'),
('09000-000', 'Rua I', 'São Paulo', 'SP'),
('10000-000', 'Rua J', 'São Paulo', 'SP'),
('11000-000', 'Rua K', 'São Paulo', 'SP'),
('12000-000', 'Rua L', 'São Paulo', 'SP'),
('13000-000', 'Rua M', 'São Paulo', 'SP'),
('14000-000', 'Rua N', 'São Paulo', 'SP'),
('15000-000', 'Rua O', 'São Paulo', 'SP'),
('16000-000', 'Rua P', 'São Paulo', 'SP'),
('17000-000', 'Rua Q', 'São Paulo', 'SP'),
('18000-000', 'Rua R', 'São Paulo', 'SP'),
('19000-000', 'Rua S', 'São Paulo', 'SP'),
('20000-000', 'Rua T', 'São Paulo', 'SP'),
('21000-000', 'Rua U', 'São Paulo', 'SP');

INSERT INTO cliente (nome, cpf, id_endereco) VALUES
('Cliente 1', '111.111.111-11', (SELECT id FROM endereco WHERE cep = '01000-000')),
('Cliente 2', '222.222.222-22', (SELECT id FROM endereco WHERE cep = '02000-000')),
('Cliente 3', '333.333.333-33', (SELECT id FROM endereco WHERE cep = '03000-000')),
('Cliente 4', '444.444.444-44', (SELECT id FROM endereco WHERE cep = '04000-000')),
('Cliente 5', '555.555.555-55', (SELECT id FROM endereco WHERE cep = '05000-000')),
('Cliente 6', '666.666.666-66', (SELECT id FROM endereco WHERE cep = '06000-000')),
('Cliente 7', '777.777.777-77', (SELECT id FROM endereco WHERE cep = '07000-000')),
('Cliente 8', '888.888.888-88', (SELECT id FROM endereco WHERE cep = '08000-000')),
('Cliente 9', '999.999.999-99', (SELECT id FROM endereco WHERE cep = '09000-000')),
('Cliente 10', '101.010.101-10', (SELECT id FROM endereco WHERE cep = '10000-000')),
('Cliente 11', '121.121.121-12', (SELECT id FROM endereco WHERE cep = '11000-000')),
('Cliente 12', '131.131.131-13', (SELECT id FROM endereco WHERE cep = '12000-000')),
('Cliente 13', '141.141.141-14', (SELECT id FROM endereco WHERE cep = '13000-000')),
('Cliente 14', '151.151.151-15', (SELECT id FROM endereco WHERE cep = '14000-000')),
('Cliente 15', '161.161.161-16', (SELECT id FROM endereco WHERE cep = '15000-000')),
('Cliente 16', '171.171.171-17', (SELECT id FROM endereco WHERE cep = '16000-000')),
('Cliente 17', '181.181.181-18', (SELECT id FROM endereco WHERE cep = '17000-000')),
('Cliente 18', '191.191.191-19', (SELECT id FROM endereco WHERE cep = '18000-000')),
('Cliente 19', '202.202.202-20', (SELECT id FROM endereco WHERE cep = '19000-000')),
('Cliente 20', '212.212.212-21', (SELECT id FROM endereco WHERE cep = '20000-000'));

INSERT INTO agencia (numero, id_endereco) VALUES
('001', (SELECT id FROM endereco WHERE cep = '01000-000')),
('002', (SELECT id FROM endereco WHERE cep = '02000-000')),
('003', (SELECT id FROM endereco WHERE cep = '03000-000')),
('004', (SELECT id FROM endereco WHERE cep = '04000-000')),
('005', (SELECT id FROM endereco WHERE cep = '05000-000')),
('006', (SELECT id FROM endereco WHERE cep = '06000-000')),
('007', (SELECT id FROM endereco WHERE cep = '07000-000')),
('008', (SELECT id FROM endereco WHERE cep = '08000-000')),
('009', (SELECT id FROM endereco WHERE cep = '09000-000')),
('010', (SELECT id FROM endereco WHERE cep = '10000-000')),
('011', (SELECT id FROM endereco WHERE cep = '11000-000')),
('012', (SELECT id FROM endereco WHERE cep = '12000-000')),
('013', (SELECT id FROM endereco WHERE cep = '13000-000')),
('014', (SELECT id FROM endereco WHERE cep = '14000-000')),
('015', (SELECT id FROM endereco WHERE cep = '15000-000')),
('016', (SELECT id FROM endereco WHERE cep = '16000-000')),
('017', (SELECT id FROM endereco WHERE cep = '17000-000')),
('018', (SELECT id FROM endereco WHERE cep = '18000-000')),
('019', (SELECT id FROM endereco WHERE cep = '19000-000')),
('020', (SELECT id FROM endereco WHERE cep = '20000-000'));

INSERT INTO funcionario (nome, cpf, id_cargo, id_agencia) VALUES
('Funcionario 1', '111.111.111-11', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '001')),
('Funcionario 2', '222.222.222-22', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '002')),
('Funcionario 3', '333.333.333-33', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '003')),
('Funcionario 4', '444.444.444-44', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '004')),
('Funcionario 5', '555.555.555-55', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '005')),
('Funcionario 6', '666.666.666-66', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '006')),
('Funcionario 7', '777.777.777-77', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '007')),
('Funcionario 8', '888.888.888-88', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '008')),
('Funcionario 9', '999.999.999-99', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '009')),
('Funcionario 10', '101.010.101-10', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '010')),
('Funcionario 11', '121.121.121-12', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '011')),
('Funcionario 12', '131.131.131-13', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '012')),
('Funcionario 13', '141.141.141-14', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '013')),
('Funcionario 14', '151.151.151-15', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '014')),
('Funcionario 15', '161.161.161-16', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '015')),
('Funcionario 16', '171.171.171-17', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '016')),
('Funcionario 17', '181.181.181-18', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '017')),
('Funcionario 18', '191.191.191-19', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '018')),
('Funcionario 19', '202.202.202-20', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '019')),
('Funcionario 20', '212.212.212-21', (SELECT id FROM cargo WHERE nome = 'GERENTE'), (SELECT id FROM agencia WHERE numero = '020'));

INSERT INTO conta (nome, saldo, id_tipoConta, id_cliente) VALUES
('Conta 1', 1000.00, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '111.111.111-11')),
('Conta 2', 1500.50, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '222.222.222-22')),
('Conta 3', 2000.75, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '333.333.333-33')),
('Conta 4', 2500.25, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '444.444.444-44')),
('Conta 5', 3000.00, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '555.555.555-55')),
('Conta 6', 3500.50, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '666.666.666-66')),
('Conta 7', 4000.75, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '777.777.777-77')),
('Conta 8', 4500.25, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '888.888.888-88')),
('Conta 9', 5000.00, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '999.999.999-99')),
('Conta 10', 5500.50, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '101.010.101-10')),
('Conta 11', 6000.75, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '121.121.121-12')),
('Conta 12', 6500.25, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '131.131.131-13')),
('Conta 13', 7000.00, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '141.141.141-14')),
('Conta 14', 7500.50, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '151.151.151-15')),
('Conta 15', 8000.75, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '161.161.161-16')),
('Conta 16', 8500.25, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '171.171.171-17')),
('Conta 17', 9000.00, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '181.181.181-18')),
('Conta 18', 9500.50, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '191.191.191-19')),
('Conta 19', 10000.75, (SELECT id FROM tipoConta WHERE nome = 'CORRENTE'), (SELECT id FROM cliente WHERE cpf = '202.202.202-20')),
('Conta 20', 10500.25, (SELECT id FROM tipoConta WHERE nome = 'POUPANCA'), (SELECT id FROM cliente WHERE cpf = '212.212.212-21'));

INSERT INTO transacao (data, valor, id_tipoTransacao) VALUES
('2024-08-01', 1000.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-02', 500.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-03', 1500.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA')),
('2024-08-04', 200.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-05', 2500.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-06', 300.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA')),
('2024-08-07', 3500.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-08', 400.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-09', 4500.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA')),
('2024-08-10', 500.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-11', 5500.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-12', 600.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA')),
('2024-08-13', 6500.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-14', 700.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-15', 7500.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA')),
('2024-08-16', 800.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-17', 8500.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-18', 900.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA')),
('2024-08-19', 9500.00, (SELECT id FROM tipoTransacao WHERE nome = 'DEPOSITO')),
('2024-08-20', 1000.00, (SELECT id FROM tipoTransacao WHERE nome = 'SAQUE')),
('2024-08-21', 10500.00, (SELECT id FROM tipoTransacao WHERE nome = 'TRANSFERENCIA'));