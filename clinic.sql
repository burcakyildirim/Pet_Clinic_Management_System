PGDMP                          {            clinic    13.13    13.13 G                0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false                       0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false                       0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false                       1262    19830    clinic    DATABASE     d   CREATE DATABASE clinic WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_T�rkiye.1254';
    DROP DATABASE clinic;
                postgres    false            �            1259    36138    animals    TABLE     �  CREATE TABLE public.animals (
    date_of_birth date,
    animal_customer_id integer NOT NULL,
    animal_id bigint NOT NULL,
    animal_name character varying(250),
    breed character varying(250),
    colour character varying(250),
    species character varying(250),
    gender character varying(255),
    CONSTRAINT animals_gender_check CHECK (((gender)::text = ANY ((ARRAY['MALE'::character varying, 'FEMALE'::character varying])::text[])))
);
    DROP TABLE public.animals;
       public         heap    postgres    false            �            1259    36134    animals_animal_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.animals_animal_customer_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.animals_animal_customer_id_seq;
       public          postgres    false    202                       0    0    animals_animal_customer_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.animals_animal_customer_id_seq OWNED BY public.animals.animal_customer_id;
          public          postgres    false    200            �            1259    36136    animals_animal_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.animals_animal_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.animals_animal_id_seq;
       public          postgres    false    202                       0    0    animals_animal_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.animals_animal_id_seq OWNED BY public.animals.animal_id;
          public          postgres    false    201            �            1259    36155    appointments    TABLE     �   CREATE TABLE public.appointments (
    appointment_animal_id integer NOT NULL,
    appointment_doctor_id integer NOT NULL,
    appointment_id bigint NOT NULL,
    date timestamp(6) without time zone
);
     DROP TABLE public.appointments;
       public         heap    postgres    false            �            1259    36149 &   appointments_appointment_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_animal_id_seq;
       public          postgres    false    206                       0    0 &   appointments_appointment_animal_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_animal_id_seq OWNED BY public.appointments.appointment_animal_id;
          public          postgres    false    203            �            1259    36151 &   appointments_appointment_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 =   DROP SEQUENCE public.appointments_appointment_doctor_id_seq;
       public          postgres    false    206                       0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE OWNED BY     q   ALTER SEQUENCE public.appointments_appointment_doctor_id_seq OWNED BY public.appointments.appointment_doctor_id;
          public          postgres    false    204            �            1259    36153    appointments_appointment_id_seq    SEQUENCE     �   CREATE SEQUENCE public.appointments_appointment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.appointments_appointment_id_seq;
       public          postgres    false    206                       0    0    appointments_appointment_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.appointments_appointment_id_seq OWNED BY public.appointments.appointment_id;
          public          postgres    false    205            �            1259    36167    available_dates    TABLE     �   CREATE TABLE public.available_dates (
    available_date date,
    available_doctor_id integer NOT NULL,
    available_id bigint NOT NULL
);
 #   DROP TABLE public.available_dates;
       public         heap    postgres    false            �            1259    36163 '   available_dates_available_doctor_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_doctor_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 >   DROP SEQUENCE public.available_dates_available_doctor_id_seq;
       public          postgres    false    209            	           0    0 '   available_dates_available_doctor_id_seq    SEQUENCE OWNED BY     s   ALTER SEQUENCE public.available_dates_available_doctor_id_seq OWNED BY public.available_dates.available_doctor_id;
          public          postgres    false    207            �            1259    36165     available_dates_available_id_seq    SEQUENCE     �   CREATE SEQUENCE public.available_dates_available_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 7   DROP SEQUENCE public.available_dates_available_id_seq;
       public          postgres    false    209            
           0    0     available_dates_available_id_seq    SEQUENCE OWNED BY     e   ALTER SEQUENCE public.available_dates_available_id_seq OWNED BY public.available_dates.available_id;
          public          postgres    false    208            �            1259    36176 	   customers    TABLE       CREATE TABLE public.customers (
    customer_id bigint NOT NULL,
    customer_address character varying(250),
    customer_city character varying(250),
    customer_mail character varying(250),
    customer_name character varying(250),
    customer_phone character varying(250)
);
    DROP TABLE public.customers;
       public         heap    postgres    false            �            1259    36174    customers_customer_id_seq    SEQUENCE     �   CREATE SEQUENCE public.customers_customer_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 0   DROP SEQUENCE public.customers_customer_id_seq;
       public          postgres    false    211                       0    0    customers_customer_id_seq    SEQUENCE OWNED BY     W   ALTER SEQUENCE public.customers_customer_id_seq OWNED BY public.customers.customer_id;
          public          postgres    false    210            �            1259    36187    doctors    TABLE       CREATE TABLE public.doctors (
    doctor_id bigint NOT NULL,
    doctor_address character varying(250),
    doctor_city character varying(250),
    doctor_mail character varying(250),
    doctor_name character varying(250),
    doctor_phone character varying(250)
);
    DROP TABLE public.doctors;
       public         heap    postgres    false            �            1259    36185    doctors_doctor_id_seq    SEQUENCE     ~   CREATE SEQUENCE public.doctors_doctor_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.doctors_doctor_id_seq;
       public          postgres    false    213                       0    0    doctors_doctor_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.doctors_doctor_id_seq OWNED BY public.doctors.doctor_id;
          public          postgres    false    212            �            1259    36200    vaccines    TABLE     �   CREATE TABLE public.vaccines (
    finish_date date,
    start_date date,
    vaccine_animal_id integer NOT NULL,
    vaccine_id bigint NOT NULL,
    vaccine_code character varying(250),
    vaccine_name character varying(250)
);
    DROP TABLE public.vaccines;
       public         heap    postgres    false            �            1259    36196    vaccines_vaccine_animal_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_animal_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 5   DROP SEQUENCE public.vaccines_vaccine_animal_id_seq;
       public          postgres    false    216                       0    0    vaccines_vaccine_animal_id_seq    SEQUENCE OWNED BY     a   ALTER SEQUENCE public.vaccines_vaccine_animal_id_seq OWNED BY public.vaccines.vaccine_animal_id;
          public          postgres    false    214            �            1259    36198    vaccines_vaccine_id_seq    SEQUENCE     �   CREATE SEQUENCE public.vaccines_vaccine_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 .   DROP SEQUENCE public.vaccines_vaccine_id_seq;
       public          postgres    false    216                       0    0    vaccines_vaccine_id_seq    SEQUENCE OWNED BY     S   ALTER SEQUENCE public.vaccines_vaccine_id_seq OWNED BY public.vaccines.vaccine_id;
          public          postgres    false    215            N           2604    36141    animals animal_customer_id    DEFAULT     �   ALTER TABLE ONLY public.animals ALTER COLUMN animal_customer_id SET DEFAULT nextval('public.animals_animal_customer_id_seq'::regclass);
 I   ALTER TABLE public.animals ALTER COLUMN animal_customer_id DROP DEFAULT;
       public          postgres    false    200    202    202            O           2604    36142    animals animal_id    DEFAULT     v   ALTER TABLE ONLY public.animals ALTER COLUMN animal_id SET DEFAULT nextval('public.animals_animal_id_seq'::regclass);
 @   ALTER TABLE public.animals ALTER COLUMN animal_id DROP DEFAULT;
       public          postgres    false    202    201    202            Q           2604    36158 "   appointments appointment_animal_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_animal_id SET DEFAULT nextval('public.appointments_appointment_animal_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_animal_id DROP DEFAULT;
       public          postgres    false    206    203    206            R           2604    36159 "   appointments appointment_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_doctor_id SET DEFAULT nextval('public.appointments_appointment_doctor_id_seq'::regclass);
 Q   ALTER TABLE public.appointments ALTER COLUMN appointment_doctor_id DROP DEFAULT;
       public          postgres    false    204    206    206            S           2604    36160    appointments appointment_id    DEFAULT     �   ALTER TABLE ONLY public.appointments ALTER COLUMN appointment_id SET DEFAULT nextval('public.appointments_appointment_id_seq'::regclass);
 J   ALTER TABLE public.appointments ALTER COLUMN appointment_id DROP DEFAULT;
       public          postgres    false    206    205    206            T           2604    36170 #   available_dates available_doctor_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_doctor_id SET DEFAULT nextval('public.available_dates_available_doctor_id_seq'::regclass);
 R   ALTER TABLE public.available_dates ALTER COLUMN available_doctor_id DROP DEFAULT;
       public          postgres    false    207    209    209            U           2604    36171    available_dates available_id    DEFAULT     �   ALTER TABLE ONLY public.available_dates ALTER COLUMN available_id SET DEFAULT nextval('public.available_dates_available_id_seq'::regclass);
 K   ALTER TABLE public.available_dates ALTER COLUMN available_id DROP DEFAULT;
       public          postgres    false    209    208    209            V           2604    36179    customers customer_id    DEFAULT     ~   ALTER TABLE ONLY public.customers ALTER COLUMN customer_id SET DEFAULT nextval('public.customers_customer_id_seq'::regclass);
 D   ALTER TABLE public.customers ALTER COLUMN customer_id DROP DEFAULT;
       public          postgres    false    211    210    211            W           2604    36190    doctors doctor_id    DEFAULT     v   ALTER TABLE ONLY public.doctors ALTER COLUMN doctor_id SET DEFAULT nextval('public.doctors_doctor_id_seq'::regclass);
 @   ALTER TABLE public.doctors ALTER COLUMN doctor_id DROP DEFAULT;
       public          postgres    false    213    212    213            X           2604    36203    vaccines vaccine_animal_id    DEFAULT     �   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_animal_id SET DEFAULT nextval('public.vaccines_vaccine_animal_id_seq'::regclass);
 I   ALTER TABLE public.vaccines ALTER COLUMN vaccine_animal_id DROP DEFAULT;
       public          postgres    false    214    216    216            Y           2604    36204    vaccines vaccine_id    DEFAULT     z   ALTER TABLE ONLY public.vaccines ALTER COLUMN vaccine_id SET DEFAULT nextval('public.vaccines_vaccine_id_seq'::regclass);
 B   ALTER TABLE public.vaccines ALTER COLUMN vaccine_id DROP DEFAULT;
       public          postgres    false    216    215    216            �          0    36138    animals 
   TABLE DATA           |   COPY public.animals (date_of_birth, animal_customer_id, animal_id, animal_name, breed, colour, species, gender) FROM stdin;
    public          postgres    false    202   EX       �          0    36155    appointments 
   TABLE DATA           j   COPY public.appointments (appointment_animal_id, appointment_doctor_id, appointment_id, date) FROM stdin;
    public          postgres    false    206   	Y       �          0    36167    available_dates 
   TABLE DATA           \   COPY public.available_dates (available_date, available_doctor_id, available_id) FROM stdin;
    public          postgres    false    209   dY       �          0    36176 	   customers 
   TABLE DATA              COPY public.customers (customer_id, customer_address, customer_city, customer_mail, customer_name, customer_phone) FROM stdin;
    public          postgres    false    211   �Y       �          0    36187    doctors 
   TABLE DATA           q   COPY public.doctors (doctor_id, doctor_address, doctor_city, doctor_mail, doctor_name, doctor_phone) FROM stdin;
    public          postgres    false    213   �Z       �          0    36200    vaccines 
   TABLE DATA           v   COPY public.vaccines (finish_date, start_date, vaccine_animal_id, vaccine_id, vaccine_code, vaccine_name) FROM stdin;
    public          postgres    false    216   }[                  0    0    animals_animal_customer_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.animals_animal_customer_id_seq', 1, false);
          public          postgres    false    200                       0    0    animals_animal_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.animals_animal_id_seq', 5, true);
          public          postgres    false    201                       0    0 &   appointments_appointment_animal_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.appointments_appointment_animal_id_seq', 1, false);
          public          postgres    false    203                       0    0 &   appointments_appointment_doctor_id_seq    SEQUENCE SET     U   SELECT pg_catalog.setval('public.appointments_appointment_doctor_id_seq', 1, false);
          public          postgres    false    204                       0    0    appointments_appointment_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.appointments_appointment_id_seq', 5, true);
          public          postgres    false    205                       0    0 '   available_dates_available_doctor_id_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.available_dates_available_doctor_id_seq', 1, false);
          public          postgres    false    207                       0    0     available_dates_available_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.available_dates_available_id_seq', 5, true);
          public          postgres    false    208                       0    0    customers_customer_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.customers_customer_id_seq', 5, true);
          public          postgres    false    210                       0    0    doctors_doctor_id_seq    SEQUENCE SET     C   SELECT pg_catalog.setval('public.doctors_doctor_id_seq', 5, true);
          public          postgres    false    212                       0    0    vaccines_vaccine_animal_id_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.vaccines_vaccine_animal_id_seq', 1, false);
          public          postgres    false    214                       0    0    vaccines_vaccine_id_seq    SEQUENCE SET     E   SELECT pg_catalog.setval('public.vaccines_vaccine_id_seq', 5, true);
          public          postgres    false    215            [           2606    36148    animals animals_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT animals_pkey PRIMARY KEY (animal_id);
 >   ALTER TABLE ONLY public.animals DROP CONSTRAINT animals_pkey;
       public            postgres    false    202            ]           2606    36162    appointments appointments_pkey 
   CONSTRAINT     h   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT appointments_pkey PRIMARY KEY (appointment_id);
 H   ALTER TABLE ONLY public.appointments DROP CONSTRAINT appointments_pkey;
       public            postgres    false    206            _           2606    36173 $   available_dates available_dates_pkey 
   CONSTRAINT     l   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT available_dates_pkey PRIMARY KEY (available_id);
 N   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT available_dates_pkey;
       public            postgres    false    209            a           2606    36184    customers customers_pkey 
   CONSTRAINT     _   ALTER TABLE ONLY public.customers
    ADD CONSTRAINT customers_pkey PRIMARY KEY (customer_id);
 B   ALTER TABLE ONLY public.customers DROP CONSTRAINT customers_pkey;
       public            postgres    false    211            c           2606    36195    doctors doctors_pkey 
   CONSTRAINT     Y   ALTER TABLE ONLY public.doctors
    ADD CONSTRAINT doctors_pkey PRIMARY KEY (doctor_id);
 >   ALTER TABLE ONLY public.doctors DROP CONSTRAINT doctors_pkey;
       public            postgres    false    213            e           2606    36209    vaccines vaccines_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT vaccines_pkey PRIMARY KEY (vaccine_id);
 @   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT vaccines_pkey;
       public            postgres    false    216            h           2606    36220 '   appointments fk27d0xcbajwaeeun2doojsae4    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fk27d0xcbajwaeeun2doojsae4 FOREIGN KEY (appointment_doctor_id) REFERENCES public.doctors(doctor_id);
 Q   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fk27d0xcbajwaeeun2doojsae4;
       public          postgres    false    2915    213    206            i           2606    36225 +   available_dates fk7u5funqvtlkcrft3rkhlgsyoh    FK CONSTRAINT     �   ALTER TABLE ONLY public.available_dates
    ADD CONSTRAINT fk7u5funqvtlkcrft3rkhlgsyoh FOREIGN KEY (available_doctor_id) REFERENCES public.doctors(doctor_id);
 U   ALTER TABLE ONLY public.available_dates DROP CONSTRAINT fk7u5funqvtlkcrft3rkhlgsyoh;
       public          postgres    false    213    209    2915            j           2606    36230 $   vaccines fkekhfjmpsduds8nnilqe9b467v    FK CONSTRAINT     �   ALTER TABLE ONLY public.vaccines
    ADD CONSTRAINT fkekhfjmpsduds8nnilqe9b467v FOREIGN KEY (vaccine_animal_id) REFERENCES public.animals(animal_id);
 N   ALTER TABLE ONLY public.vaccines DROP CONSTRAINT fkekhfjmpsduds8nnilqe9b467v;
       public          postgres    false    216    202    2907            f           2606    36210 #   animals fknjsvd8kplxqmf48ybxayrx6ru    FK CONSTRAINT     �   ALTER TABLE ONLY public.animals
    ADD CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru FOREIGN KEY (animal_customer_id) REFERENCES public.customers(customer_id);
 M   ALTER TABLE ONLY public.animals DROP CONSTRAINT fknjsvd8kplxqmf48ybxayrx6ru;
       public          postgres    false    211    2913    202            g           2606    36215 (   appointments fko4t945rb708af9ry6syof7bwt    FK CONSTRAINT     �   ALTER TABLE ONLY public.appointments
    ADD CONSTRAINT fko4t945rb708af9ry6syof7bwt FOREIGN KEY (appointment_animal_id) REFERENCES public.animals(animal_id);
 R   ALTER TABLE ONLY public.appointments DROP CONSTRAINT fko4t945rb708af9ry6syof7bwt;
       public          postgres    false    202    2907    206            �   �   x�U�A
�0EדSx�+�e�.�WB71�&48%
�z�^�#T�����d(#
X(��3�� �S�	N5^��!��c�1Jrc.H���^���৊d'�u
���PiG;� G��g�K������wo����)#.��ʨ�
jze2v��d��>Ƚ>��c�}�B      �   K   x�=���0D�3TA��!��Z�6��>����6����8��~	Cl	�Jh��S��'71咬��?K�CU;�)�      �   4   x�Eǹ  �x�|<�����D��(ݥu�70Κ ����.&S�J�4�      �   �   x�u�;�0���9'����e$��X5m�ȔJ���0wgkF !u��^�ϖ��r�C�x��I�`񊰈�*��ʣq���a�?1d�V���T
%��Љ>����:G_cǇ��$>�9�ә��C��~�<�a����c/�ʋw��������0��� S:W���<���w������6�R����6B<��m�      �   �   x�u�Kj�0����:�A���*�E!�"Y���C,,)E��z�ns�!�R�HW�A��3�yw�e������N# `h��������@����~��PH��Z��I�q���SK�nCt>�t�V���L�8_�4U�F�%S�~��mƅ�P6C�ȯ疜	P)���Nʡ�q��^{ɛ�@k�/��e�#�W�yI_�\4U�C��v����ύ:��ҝ���z��N����Db�2���_z      �   t   x�3202�54�54�4�29A��6��.M)��2ª���2BRe�i��F�ƜG6^��X�X�Y��H ��5������M�+2F(n
���&�����
.\1z\\\ ��*�     