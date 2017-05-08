--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.10
-- Dumped by pg_dump version 9.4.10
-- Started on 2017-05-07 23:32:10 -05

SET statement_timeout = 0;
SET lock_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;

--
-- TOC entry 1 (class 3079 OID 11861)
-- Name: plpgsql; Type: EXTENSION; Schema: -; Owner: 
--

CREATE EXTENSION IF NOT EXISTS plpgsql WITH SCHEMA pg_catalog;


--
-- TOC entry 2019 (class 0 OID 0)
-- Dependencies: 1
-- Name: EXTENSION plpgsql; Type: COMMENT; Schema: -; Owner: 
--

COMMENT ON EXTENSION plpgsql IS 'PL/pgSQL procedural language';


SET search_path = public, pg_catalog;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 173 (class 1259 OID 16393)
-- Name: records; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE records (
    id integer NOT NULL,
    amount numeric,
    name character varying(50),
    application_date timestamp without time zone,
    delivery_date timestamp without time zone,
    state character varying(30)
);


ALTER TABLE records OWNER TO postgres;

--
-- TOC entry 174 (class 1259 OID 16396)
-- Name: records_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE records_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE records_id_seq OWNER TO postgres;

--
-- TOC entry 2020 (class 0 OID 0)
-- Dependencies: 174
-- Name: records_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE records_id_seq OWNED BY records.id;


--
-- TOC entry 176 (class 1259 OID 16484)
-- Name: users; Type: TABLE; Schema: public; Owner: postgres; Tablespace: 
--

CREATE TABLE users (
    id bigint NOT NULL,
    login character varying(255),
    password character varying(255)
);


ALTER TABLE users OWNER TO postgres;

--
-- TOC entry 175 (class 1259 OID 16482)
-- Name: users_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE users_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE users_id_seq OWNER TO postgres;

--
-- TOC entry 2021 (class 0 OID 0)
-- Dependencies: 175
-- Name: users_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE users_id_seq OWNED BY users.id;


--
-- TOC entry 1893 (class 2604 OID 16398)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY records ALTER COLUMN id SET DEFAULT nextval('records_id_seq'::regclass);


--
-- TOC entry 1894 (class 2604 OID 16487)
-- Name: id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY users ALTER COLUMN id SET DEFAULT nextval('users_id_seq'::regclass);


--
-- TOC entry 2008 (class 0 OID 16393)
-- Dependencies: 173
-- Data for Name: records; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY records (id, amount, name, application_date, delivery_date, state) FROM stdin;
3	4.34	Test	2017-05-07 17:39:38.193	2017-05-07 19:27:27.264	delivered
1	100.00	Initial Ammount	2017-05-07 14:06:45.985	2017-05-07 19:21:33.364	added
2	4.56	Juan	2017-05-07 15:00:48.355	2017-05-07 19:27:36.842	delivered
6	6.78	Pedro	2017-05-07 19:22:10.313	2017-05-07 19:27:38.429	delivered
7	0.01	José	2017-05-07 19:29:50.763	2017-05-07 19:52:01.08	delivered
8	32.34	Esteban	2017-05-07 19:54:50.382	2017-05-07 20:38:36.253	delivered
9	0.13	Silvia	2017-05-07 21:54:26.319	2017-05-07 21:54:26.319	pending
10	45.3	Johana	2017-05-07 22:05:37.14	2017-05-07 22:05:37.14	pending
11	32.34	Marco	2017-05-07 22:13:57.757	2017-05-07 22:13:57.757	pending
\.


--
-- TOC entry 2022 (class 0 OID 0)
-- Dependencies: 174
-- Name: records_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('records_id_seq', 11, true);


--
-- TOC entry 2011 (class 0 OID 16484)
-- Dependencies: 176
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY users (id, login, password) FROM stdin;
2	user2	pass2
\.


--
-- TOC entry 2023 (class 0 OID 0)
-- Dependencies: 175
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('users_id_seq', 3, true);


--
-- TOC entry 1896 (class 2606 OID 16403)
-- Name: records_pk; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY records
    ADD CONSTRAINT records_pk PRIMARY KEY (id);


--
-- TOC entry 1898 (class 2606 OID 16492)
-- Name: users_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres; Tablespace: 
--

ALTER TABLE ONLY users
    ADD CONSTRAINT users_pkey PRIMARY KEY (id);


--
-- TOC entry 2018 (class 0 OID 0)
-- Dependencies: 6
-- Name: public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


-- Completed on 2017-05-07 23:32:10 -05

--
-- PostgreSQL database dump complete
--

