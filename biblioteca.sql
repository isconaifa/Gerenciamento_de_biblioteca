--
-- PostgreSQL database dump
--

-- Dumped from database version 14.8 (Debian 14.8-1.pgdg110+1)
-- Dumped by pg_dump version 14.8 (Ubuntu 14.8-0ubuntu0.22.04.1)

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: autor; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor (
    id integer NOT NULL,
    cpf character varying(255),
    endereco character varying(255),
    nome character varying(255)
);


ALTER TABLE public.autor OWNER TO postgres;

--
-- Name: autor_livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor_livro (
    id integer NOT NULL,
    autor integer,
    livro integer
);


ALTER TABLE public.autor_livro OWNER TO postgres;

--
-- Name: autor_reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.autor_reserva (
    funcionario_id integer NOT NULL,
    reserva_id integer NOT NULL
);


ALTER TABLE public.autor_reserva OWNER TO postgres;

--
-- Name: editora; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.editora (
    id integer NOT NULL,
    nome character varying(255),
    obra character varying(255),
    telefone character varying(255)
);


ALTER TABLE public.editora OWNER TO postgres;

--
-- Name: genero; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.genero (
    id integer NOT NULL,
    nome character varying(255)
);


ALTER TABLE public.genero OWNER TO postgres;

--
-- Name: generolivro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.generolivro (
    id integer NOT NULL,
    genero integer,
    livro integer
);


ALTER TABLE public.generolivro OWNER TO postgres;

--
-- Name: livro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.livro (
    id integer NOT NULL,
    isbn character varying(255),
    data_publicacao timestamp without time zone,
    titulo character varying(255),
    editor_id integer
);


ALTER TABLE public.livro OWNER TO postgres;

--
-- Name: reserva; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reserva (
    id integer NOT NULL,
    data_devolucao integer NOT NULL,
    data_reserva integer NOT NULL,
    funcionario_id integer,
    usuario_id integer
);


ALTER TABLE public.reserva OWNER TO postgres;

--
-- Name: reservalivro; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.reservalivro (
    id integer NOT NULL,
    livro integer,
    reserva integer
);


ALTER TABLE public.reservalivro OWNER TO postgres;

--
-- Name: seq_autor; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_autor
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_autor OWNER TO postgres;

--
-- Name: seq_editora_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_editora_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_editora_id OWNER TO postgres;

--
-- Name: seq_genero_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_genero_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_genero_id OWNER TO postgres;

--
-- Name: seq_generolivro; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_generolivro
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_generolivro OWNER TO postgres;

--
-- Name: seq_livro_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_livro_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_livro_id OWNER TO postgres;

--
-- Name: seq_reserva_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_reserva_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_reserva_id OWNER TO postgres;

--
-- Name: seq_reserva_livro; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_reserva_livro
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_reserva_livro OWNER TO postgres;

--
-- Name: seq_reservalivro_id; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_reservalivro_id
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_reservalivro_id OWNER TO postgres;

--
-- Name: seq_usuario; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.seq_usuario
    START WITH 1
    INCREMENT BY 50
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.seq_usuario OWNER TO postgres;

--
-- Name: usuario; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.usuario (
    id integer NOT NULL,
    cpf character varying(255),
    endereco character varying(255),
    nome character varying(255)
);


ALTER TABLE public.usuario OWNER TO postgres;

--
-- Data for Name: autor; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autor (id, cpf, endereco, nome) FROM stdin;
\.


--
-- Data for Name: autor_livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autor_livro (id, autor, livro) FROM stdin;
\.


--
-- Data for Name: autor_reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.autor_reserva (funcionario_id, reserva_id) FROM stdin;
\.


--
-- Data for Name: editora; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.editora (id, nome, obra, telefone) FROM stdin;
\.


--
-- Data for Name: genero; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.genero (id, nome) FROM stdin;
\.


--
-- Data for Name: generolivro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.generolivro (id, genero, livro) FROM stdin;
\.


--
-- Data for Name: livro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.livro (id, isbn, data_publicacao, titulo, editor_id) FROM stdin;
\.


--
-- Data for Name: reserva; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reserva (id, data_devolucao, data_reserva, funcionario_id, usuario_id) FROM stdin;
\.


--
-- Data for Name: reservalivro; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.reservalivro (id, livro, reserva) FROM stdin;
\.


--
-- Data for Name: usuario; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.usuario (id, cpf, endereco, nome) FROM stdin;
\.


--
-- Name: seq_autor; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_autor', 1, false);


--
-- Name: seq_editora_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_editora_id', 1, false);


--
-- Name: seq_genero_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_genero_id', 1, false);


--
-- Name: seq_generolivro; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_generolivro', 1, false);


--
-- Name: seq_livro_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_livro_id', 1, false);


--
-- Name: seq_reserva_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_reserva_id', 1, false);


--
-- Name: seq_reserva_livro; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_reserva_livro', 1, false);


--
-- Name: seq_reservalivro_id; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_reservalivro_id', 1, false);


--
-- Name: seq_usuario; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.seq_usuario', 1, false);


--
-- Name: autor_livro autor_livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_livro
    ADD CONSTRAINT autor_livro_pkey PRIMARY KEY (id);


--
-- Name: autor autor_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor
    ADD CONSTRAINT autor_pkey PRIMARY KEY (id);


--
-- Name: editora editora_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.editora
    ADD CONSTRAINT editora_pkey PRIMARY KEY (id);


--
-- Name: genero genero_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.genero
    ADD CONSTRAINT genero_pkey PRIMARY KEY (id);


--
-- Name: generolivro generolivro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.generolivro
    ADD CONSTRAINT generolivro_pkey PRIMARY KEY (id);


--
-- Name: livro livro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT livro_pkey PRIMARY KEY (id);


--
-- Name: reserva reserva_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT reserva_pkey PRIMARY KEY (id);


--
-- Name: reservalivro reservalivro_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservalivro
    ADD CONSTRAINT reservalivro_pkey PRIMARY KEY (id);


--
-- Name: autor_reserva uk_mj49s2hp6jvjmvd2mq01hsa01; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_reserva
    ADD CONSTRAINT uk_mj49s2hp6jvjmvd2mq01hsa01 UNIQUE (reserva_id);


--
-- Name: usuario usuario_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.usuario
    ADD CONSTRAINT usuario_pkey PRIMARY KEY (id);


--
-- Name: livro fk1srfp5f878wy51ir8181f1k8o; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.livro
    ADD CONSTRAINT fk1srfp5f878wy51ir8181f1k8o FOREIGN KEY (editor_id) REFERENCES public.editora(id);


--
-- Name: generolivro fk2x2r59hmbavscggk3pvj37e5q; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.generolivro
    ADD CONSTRAINT fk2x2r59hmbavscggk3pvj37e5q FOREIGN KEY (genero) REFERENCES public.genero(id);


--
-- Name: autor_livro fk37e94xj7lljv1aa3rcknj29lt; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_livro
    ADD CONSTRAINT fk37e94xj7lljv1aa3rcknj29lt FOREIGN KEY (livro) REFERENCES public.livro(id);


--
-- Name: autor_reserva fk3k8mmifnthbrhletbqr4jgtfd; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_reserva
    ADD CONSTRAINT fk3k8mmifnthbrhletbqr4jgtfd FOREIGN KEY (funcionario_id) REFERENCES public.autor(id);


--
-- Name: reservalivro fk4swv2aq6mw6pgiykwfgiw5fa2; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservalivro
    ADD CONSTRAINT fk4swv2aq6mw6pgiykwfgiw5fa2 FOREIGN KEY (reserva) REFERENCES public.reserva(id);


--
-- Name: reservalivro fk68cjy3qwp76e36338k75xbjot; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reservalivro
    ADD CONSTRAINT fk68cjy3qwp76e36338k75xbjot FOREIGN KEY (livro) REFERENCES public.livro(id);


--
-- Name: reserva fkftwpal7d6ef8o2s68jg401587; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT fkftwpal7d6ef8o2s68jg401587 FOREIGN KEY (funcionario_id) REFERENCES public.autor(id);


--
-- Name: reserva fkiad9w96t12u3ms2ul93l97mel; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.reserva
    ADD CONSTRAINT fkiad9w96t12u3ms2ul93l97mel FOREIGN KEY (usuario_id) REFERENCES public.usuario(id);


--
-- Name: autor_reserva fkjmkl8l1sirg5dpkrmci7do7ro; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_reserva
    ADD CONSTRAINT fkjmkl8l1sirg5dpkrmci7do7ro FOREIGN KEY (reserva_id) REFERENCES public.reserva(id);


--
-- Name: autor_livro fklnjyygde3j3rylmylxxrnxhxh; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.autor_livro
    ADD CONSTRAINT fklnjyygde3j3rylmylxxrnxhxh FOREIGN KEY (autor) REFERENCES public.autor(id);


--
-- Name: generolivro fkqs8mxn8pbkawgjf8v5knc6bwg; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.generolivro
    ADD CONSTRAINT fkqs8mxn8pbkawgjf8v5knc6bwg FOREIGN KEY (livro) REFERENCES public.livro(id);


--
-- PostgreSQL database dump complete
--

