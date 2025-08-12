INSERT INTO public.psicologo (id, crp, nome, email, senha_hash) VALUES
(1, '06/12345', 'Dr. Ricardo Alves', 'ricardo.alves@clinica.com', '$2a$10$abcdefghijklmnopqrstuv'),
(2, '06/54321', 'Dra. Helena Costa', 'helena.costa@clinica.com', '$2a$10$wxyzabcdefghijklmnopq');

INSERT INTO public.paciente (id, nome_completo, cpf, rg, telefone_pessoal, informacoes_adicionais) VALUES
(1, 'Ana Silva', '111.222.333-44', '12.345.678-9', '11-91234-5678', 'Paciente apresenta quadros de ansiedade.'),
(2, 'Bruno Oliveira', '222.333.444-55', '23.456.789-0', '21-98765-4321', 'Busca terapia de casal.'),
(3, 'Carla Mendes', '333.444.555-66', '34.567.890-1', '81-99876-1234', 'Encaminhado pela escola do filho.');

INSERT INTO public.endereco (id_paciente, tipo_endereco, logradouro, numero, cidade, estado) VALUES
(1, 'PESSOAL', 'Rua das Flores', 123, 'São Paulo', 'SP'),
(1, 'TRABALHO', 'Avenida Paulista', 1000, 'São Paulo', 'SP');

INSERT INTO public.endereco (id_paciente, tipo_endereco, logradouro, numero, cidade, estado) VALUES
(2, 'PESSOAL', 'Rua de Copacabana', 456, 'Rio de Janeiro', 'RJ');

INSERT INTO public.endereco (id_paciente, tipo_endereco, logradouro, numero, cidade, estado) VALUES
(3, 'PESSOAL', 'Avenida Boa Viagem', 789, 'Recife', 'PE');

INSERT INTO public.contato_emergencia (id_paciente, nome, telefone) VALUES
(1, 'Marcos Silva (Irmão)', '11-98888-7777'),
(2, 'Juliana Oliveira (Esposa)', '21-97777-6666'),
(3, 'Fernando Mendes (Marido)', '81-96666-5555');

INSERT INTO public.Atendimento (id, data, localidade, status, psicologo_id, paciente_id) VALUES
(1, '2024-05-10 14:00:00', 'Consultório 1', 'REALIZADO', 1, 1),
(2, '2024-05-17 14:00:00', 'Consultório 1', 'REALIZADO', 1, 1),
(3, '2024-05-24 14:00:00', 'Online', 'CANCELADO', 1, 1),
(4, '2024-05-31 15:00:00', 'Consultório 2', 'REALIZADO', 1, 1),
(5, '2024-06-07 15:00:00', 'Consultório 2', 'AGENDADO', 1, 1);

INSERT INTO public.Atendimento (id, data, localidade, status, psicologo_id, paciente_id) VALUES
(6, '2024-05-20 10:00:00', 'Online', 'REALIZADO', 2, 2);

INSERT INTO public.Atendimento (id, data, localidade, status, psicologo_id, paciente_id) VALUES
(7, '2024-06-01 11:00:00', 'Consultório 3', 'AGENDADO', 2, 3);

INSERT INTO public.Prontuario (atendimento_id, descricao, dataRegistro) VALUES
(1, 'Primeira sessão. Paciente relata dificuldades no trabalho e picos de estresse. Exploramos gatilhos iniciais.', '2024-05-10'),
(2, 'Sessão focada em técnicas de respiração e mindfulness. Paciente se mostrou receptiva e relatou melhora leve.', '2024-05-17'),
(4, 'Retomada após o cancelamento. Discutimos a importância da consistência na terapia. Paciente concorda e se compromete.', '2024-05-31'),
(6, 'Discussão inicial sobre a dinâmica do relacionamento do casal. Ambos os parceiros expressaram suas frustrações.', '2024-05-20');

INSERT INTO public.pagamento (atendimento_id, valor, data, metodo, statusPagamento) VALUES
(1, 150, '2024-05-10', 'PIX', 'PAGO'),
(2, 150, '2024-05-17', 'Cartão de Crédito', 'PAGO'),
(6, 200, '2024-05-20', 'PIX', 'PAGO'),
(4, 150, '2024-05-31', 'Dinheiro', 'PENDENTE');

