--
-- PostgreSQL database dump
--

-- Dumped from database version 11.5
-- Dumped by pg_dump version 11.5

-- Started on 2019-08-22 23:57:09

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

--
-- TOC entry 2815 (class 0 OID 16431)
-- Dependencies: 197
-- Data for Name: passengers; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.passengers (id, name, lastname, seat, flight_code) FROM stdin;
1401	nacho	bosio	a01	ar0001
1451	nacho1	bosio1	a02	ar0001
1452	nacho2	bosio2	a03	ar0001
1453	nacho3	bosio4	a04	ar0001
\.


--
-- TOC entry 2824 (class 0 OID 0)
-- Dependencies: 198
-- Name: flight_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.flight_sequence', 1000, false);


--
-- TOC entry 2825 (class 0 OID 0)
-- Dependencies: 199
-- Name: passenger_sequence; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.passenger_sequence', 1500, true);


--
-- TOC entry 2826 (class 0 OID 0)
-- Dependencies: 196
-- Name: passengers_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.passengers_id_seq', 1, false);


-- Completed on 2019-08-22 23:57:10

--
-- PostgreSQL database dump complete
--

