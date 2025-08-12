CREATE TABLE public.psicologo(
    id SERIAL PRIMARY KEY,
    crp VARCHAR(20) NOT NULL UNIQUE,
    nome TEXT NOT NULL,
    email TEXT,
    senha_hash TEXT NOT NULL
);

CREATE TABLE public.paciente (
    id SERIAL PRIMARY KEY,
    nome_completo TEXT NOT NULL,
    cpf VARCHAR(14) NOT NULL UNIQUE,
    rg VARCHAR(20),
    telefone_pessoal VARCHAR(20),
    informacoes_adicionais TEXT
);

CREATE TABLE public.endereco (
    id  SERIAL PRIMARY KEY,
    id_paciente INT NOT NULL,
    tipo_endereco VARCHAR(10) NOT NULL CHECK (tipo_endereco IN ('PESSOAL', 'TRABALHO')),
    logradouro TEXT NOT NULL,
    numero INT,
    cidade TEXT NOT NULL,
    estado VARCHAR(2) NOT NULL,
    CONSTRAINT fk_paciente_endereco
        FOREIGN KEY (id_paciente)
        REFERENCES public.paciente (id)
        ON DELETE CASCADE
);

CREATE TABLE public.contato_emergencia (
    id SERIAL PRIMARY KEY,
    id_paciente INT NOT NULL,
    nome TEXT NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    CONSTRAINT fk_paciente_contato
        FOREIGN KEY (id_paciente)
        REFERENCES public.paciente(id)
        ON DELETE CASCADE
);

CREATE TABLE public.Atendimento (
    id BIGSERIAL PRIMARY KEY,
    data TIMESTAMP NOT NULL,
    localidade TEXT,
    status VARCHAR(20) NOT NULL CHECK (status IN ('AGENDADO', 'REALIZADO', 'CANCELADO', 'AUSENTE')),
    psicologo_id BIGINT NOT NULL,
    paciente_id BIGINT NOT NULL,
    CONSTRAINT fk_atendimento_psicologo
        FOREIGN KEY (psicologo_id)
        REFERENCES public.psicologo(id),

    CONSTRAINT fk_atendimento_paciente
        FOREIGN KEY (paciente_id)
        REFERENCES public.paciente(id)
);

CREATE TABLE public.Prontuario (
    id SERIAL PRIMARY KEY,
    atendimento_id BIGINT NOT NULL UNIQUE,
    descricao TEXT NOT NULL,
    dataRegistro DATE NOT NULL,
    CONSTRAINT fk_prontuario_atendimento
        FOREIGN KEY (atendimento_id)
        REFERENCES public.atendimento(id)
);

CREATE TABLE public.pagamento(
    id SERIAL PRIMARY KEY,
    atendimento_id BIGINT NOT NULL,
    valor INTEGER NOT NULL,
    data DATE NOT NULL,
    metodo TEXT NOT NULL,
    statusPagamento TEXT NOT NULL
);

ALTER TABLE public.Prontuario DROP CONSTRAINT IF EXISTS fk_prontuario_psicologo;





