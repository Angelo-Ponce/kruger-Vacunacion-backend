PGDMP         $    
            z            bdkruger    14.4    14.4 /    (           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            )           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            *           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            +           1262    16554    bdkruger    DATABASE     f   CREATE DATABASE bdkruger WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Spanish_Ecuador.1252';
    DROP DATABASE bdkruger;
                postgres    false            ?            1259    16674    employee    TABLE     ?  CREATE TABLE public.employee (
    id_employee integer NOT NULL,
    address character varying(255),
    date_of_birth timestamp without time zone,
    dni character varying(10) NOT NULL,
    email character varying(255) NOT NULL,
    last_name character varying(50) NOT NULL,
    name character varying(50) NOT NULL,
    phone character varying(255),
    id_vaccine_status integer
);
    DROP TABLE public.employee;
       public         heap    postgres    false            ?            1259    16673    employee_id_employee_seq    SEQUENCE     ?   CREATE SEQUENCE public.employee_id_employee_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.employee_id_employee_seq;
       public          postgres    false    217            ,           0    0    employee_id_employee_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.employee_id_employee_seq OWNED BY public.employee.id_employee;
          public          postgres    false    216            ?            1259    16613    rol    TABLE     ?   CREATE TABLE public.rol (
    id_rol integer NOT NULL,
    description character varying(150),
    name character varying(15) NOT NULL
);
    DROP TABLE public.rol;
       public         heap    postgres    false            ?            1259    16627    user_rol    TABLE     c   CREATE TABLE public.user_rol (
    id_user_system integer NOT NULL,
    id_rol integer NOT NULL
);
    DROP TABLE public.user_rol;
       public         heap    postgres    false            ?            1259    16618    user_system    TABLE     ?   CREATE TABLE public.user_system (
    id_user_system integer NOT NULL,
    enabled boolean NOT NULL,
    password character varying(255) NOT NULL,
    username character varying(255) NOT NULL
);
    DROP TABLE public.user_system;
       public         heap    postgres    false            ?            1259    16683    vaccine_employee    TABLE     ?   CREATE TABLE public.vaccine_employee (
    id_vaccine_employee integer NOT NULL,
    dose_numbers integer NOT NULL,
    vaccine_date timestamp without time zone NOT NULL,
    id_employee integer NOT NULL,
    id_vaccine_type integer NOT NULL
);
 $   DROP TABLE public.vaccine_employee;
       public         heap    postgres    false            ?            1259    16682 (   vaccine_employee_id_vaccine_employee_seq    SEQUENCE     ?   CREATE SEQUENCE public.vaccine_employee_id_vaccine_employee_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ?   DROP SEQUENCE public.vaccine_employee_id_vaccine_employee_seq;
       public          postgres    false    219            -           0    0 (   vaccine_employee_id_vaccine_employee_seq    SEQUENCE OWNED BY     u   ALTER SEQUENCE public.vaccine_employee_id_vaccine_employee_seq OWNED BY public.vaccine_employee.id_vaccine_employee;
          public          postgres    false    218            ?            1259    16572    vaccinestatus    TABLE        CREATE TABLE public.vaccinestatus (
    id_vaccine_status integer NOT NULL,
    description character varying(150) NOT NULL
);
 !   DROP TABLE public.vaccinestatus;
       public         heap    postgres    false            ?            1259    16571 #   vaccinestatus_id_vaccine_status_seq    SEQUENCE     ?   CREATE SEQUENCE public.vaccinestatus_id_vaccine_status_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 :   DROP SEQUENCE public.vaccinestatus_id_vaccine_status_seq;
       public          postgres    false    210            .           0    0 #   vaccinestatus_id_vaccine_status_seq    SEQUENCE OWNED BY     k   ALTER SEQUENCE public.vaccinestatus_id_vaccine_status_seq OWNED BY public.vaccinestatus.id_vaccine_status;
          public          postgres    false    209            ?            1259    16579    vaccinetype    TABLE     ?   CREATE TABLE public.vaccinetype (
    id_vaccine_type integer NOT NULL,
    description character varying(150) NOT NULL,
    name character varying(50) NOT NULL
);
    DROP TABLE public.vaccinetype;
       public         heap    postgres    false            ?            1259    16578    vaccinetype_id_vaccine_type_seq    SEQUENCE     ?   CREATE SEQUENCE public.vaccinetype_id_vaccine_type_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.vaccinetype_id_vaccine_type_seq;
       public          postgres    false    212            /           0    0    vaccinetype_id_vaccine_type_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.vaccinetype_id_vaccine_type_seq OWNED BY public.vaccinetype.id_vaccine_type;
          public          postgres    false    211            y           2604    16677    employee id_employee    DEFAULT     |   ALTER TABLE ONLY public.employee ALTER COLUMN id_employee SET DEFAULT nextval('public.employee_id_employee_seq'::regclass);
 C   ALTER TABLE public.employee ALTER COLUMN id_employee DROP DEFAULT;
       public          postgres    false    217    216    217            z           2604    16686 $   vaccine_employee id_vaccine_employee    DEFAULT     ?   ALTER TABLE ONLY public.vaccine_employee ALTER COLUMN id_vaccine_employee SET DEFAULT nextval('public.vaccine_employee_id_vaccine_employee_seq'::regclass);
 S   ALTER TABLE public.vaccine_employee ALTER COLUMN id_vaccine_employee DROP DEFAULT;
       public          postgres    false    219    218    219            w           2604    16575    vaccinestatus id_vaccine_status    DEFAULT     ?   ALTER TABLE ONLY public.vaccinestatus ALTER COLUMN id_vaccine_status SET DEFAULT nextval('public.vaccinestatus_id_vaccine_status_seq'::regclass);
 N   ALTER TABLE public.vaccinestatus ALTER COLUMN id_vaccine_status DROP DEFAULT;
       public          postgres    false    209    210    210            x           2604    16582    vaccinetype id_vaccine_type    DEFAULT     ?   ALTER TABLE ONLY public.vaccinetype ALTER COLUMN id_vaccine_type SET DEFAULT nextval('public.vaccinetype_id_vaccine_type_seq'::regclass);
 J   ALTER TABLE public.vaccinetype ALTER COLUMN id_vaccine_type DROP DEFAULT;
       public          postgres    false    211    212    212            #          0    16674    employee 
   TABLE DATA           ~   COPY public.employee (id_employee, address, date_of_birth, dni, email, last_name, name, phone, id_vaccine_status) FROM stdin;
    public          postgres    false    217   ?9                 0    16613    rol 
   TABLE DATA           8   COPY public.rol (id_rol, description, name) FROM stdin;
    public          postgres    false    213   =:       !          0    16627    user_rol 
   TABLE DATA           :   COPY public.user_rol (id_user_system, id_rol) FROM stdin;
    public          postgres    false    215   :                  0    16618    user_system 
   TABLE DATA           R   COPY public.user_system (id_user_system, enabled, password, username) FROM stdin;
    public          postgres    false    214   ?:       %          0    16683    vaccine_employee 
   TABLE DATA           y   COPY public.vaccine_employee (id_vaccine_employee, dose_numbers, vaccine_date, id_employee, id_vaccine_type) FROM stdin;
    public          postgres    false    219   ;                 0    16572    vaccinestatus 
   TABLE DATA           G   COPY public.vaccinestatus (id_vaccine_status, description) FROM stdin;
    public          postgres    false    210   b;                 0    16579    vaccinetype 
   TABLE DATA           I   COPY public.vaccinetype (id_vaccine_type, description, name) FROM stdin;
    public          postgres    false    212   ?;       0           0    0    employee_id_employee_seq    SEQUENCE SET     F   SELECT pg_catalog.setval('public.employee_id_employee_seq', 5, true);
          public          postgres    false    216            1           0    0 (   vaccine_employee_id_vaccine_employee_seq    SEQUENCE SET     V   SELECT pg_catalog.setval('public.vaccine_employee_id_vaccine_employee_seq', 5, true);
          public          postgres    false    218            2           0    0 #   vaccinestatus_id_vaccine_status_seq    SEQUENCE SET     Q   SELECT pg_catalog.setval('public.vaccinestatus_id_vaccine_status_seq', 2, true);
          public          postgres    false    209            3           0    0    vaccinetype_id_vaccine_type_seq    SEQUENCE SET     M   SELECT pg_catalog.setval('public.vaccinetype_id_vaccine_type_seq', 4, true);
          public          postgres    false    211            ?           2606    16681    employee employee_pkey 
   CONSTRAINT     ]   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT employee_pkey PRIMARY KEY (id_employee);
 @   ALTER TABLE ONLY public.employee DROP CONSTRAINT employee_pkey;
       public            postgres    false    217            ?           2606    16617    rol rol_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.rol
    ADD CONSTRAINT rol_pkey PRIMARY KEY (id_rol);
 6   ALTER TABLE ONLY public.rol DROP CONSTRAINT rol_pkey;
       public            postgres    false    213            ?           2606    16690 %   employee uk_gwcmllong7g1rcmikpkebtgm3 
   CONSTRAINT     _   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT uk_gwcmllong7g1rcmikpkebtgm3 UNIQUE (dni);
 O   ALTER TABLE ONLY public.employee DROP CONSTRAINT uk_gwcmllong7g1rcmikpkebtgm3;
       public            postgres    false    217            ?           2606    16626 (   user_system uk_iie3qktp9ue7vtaqrmukbaa9g 
   CONSTRAINT     g   ALTER TABLE ONLY public.user_system
    ADD CONSTRAINT uk_iie3qktp9ue7vtaqrmukbaa9g UNIQUE (username);
 R   ALTER TABLE ONLY public.user_system DROP CONSTRAINT uk_iie3qktp9ue7vtaqrmukbaa9g;
       public            postgres    false    214            ?           2606    16624    user_system user_system_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.user_system
    ADD CONSTRAINT user_system_pkey PRIMARY KEY (id_user_system);
 F   ALTER TABLE ONLY public.user_system DROP CONSTRAINT user_system_pkey;
       public            postgres    false    214            ?           2606    16688 &   vaccine_employee vaccine_employee_pkey 
   CONSTRAINT     u   ALTER TABLE ONLY public.vaccine_employee
    ADD CONSTRAINT vaccine_employee_pkey PRIMARY KEY (id_vaccine_employee);
 P   ALTER TABLE ONLY public.vaccine_employee DROP CONSTRAINT vaccine_employee_pkey;
       public            postgres    false    219            |           2606    16577     vaccinestatus vaccinestatus_pkey 
   CONSTRAINT     m   ALTER TABLE ONLY public.vaccinestatus
    ADD CONSTRAINT vaccinestatus_pkey PRIMARY KEY (id_vaccine_status);
 J   ALTER TABLE ONLY public.vaccinestatus DROP CONSTRAINT vaccinestatus_pkey;
       public            postgres    false    210            ~           2606    16584    vaccinetype vaccinetype_pkey 
   CONSTRAINT     g   ALTER TABLE ONLY public.vaccinetype
    ADD CONSTRAINT vaccinetype_pkey PRIMARY KEY (id_vaccine_type);
 F   ALTER TABLE ONLY public.vaccinetype DROP CONSTRAINT vaccinetype_pkey;
       public            postgres    false    212            ?           2606    16630 $   user_rol fk6vg1gs612hcqcxud4rsqnfcaw    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_rol
    ADD CONSTRAINT fk6vg1gs612hcqcxud4rsqnfcaw FOREIGN KEY (id_rol) REFERENCES public.rol(id_rol);
 N   ALTER TABLE ONLY public.user_rol DROP CONSTRAINT fk6vg1gs612hcqcxud4rsqnfcaw;
       public          postgres    false    215    213    3200            ?           2606    16635 $   user_rol fk9x8cjpp59421kfyegdlhiahsv    FK CONSTRAINT     ?   ALTER TABLE ONLY public.user_rol
    ADD CONSTRAINT fk9x8cjpp59421kfyegdlhiahsv FOREIGN KEY (id_user_system) REFERENCES public.user_system(id_user_system);
 N   ALTER TABLE ONLY public.user_rol DROP CONSTRAINT fk9x8cjpp59421kfyegdlhiahsv;
       public          postgres    false    3204    215    214            ?           2606    16691    employee fk_em_va_status    FK CONSTRAINT     ?   ALTER TABLE ONLY public.employee
    ADD CONSTRAINT fk_em_va_status FOREIGN KEY (id_vaccine_status) REFERENCES public.vaccinestatus(id_vaccine_status);
 B   ALTER TABLE ONLY public.employee DROP CONSTRAINT fk_em_va_status;
       public          postgres    false    210    3196    217            ?           2606    16696    vaccine_employee fk_ve_employee    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vaccine_employee
    ADD CONSTRAINT fk_ve_employee FOREIGN KEY (id_employee) REFERENCES public.employee(id_employee);
 I   ALTER TABLE ONLY public.vaccine_employee DROP CONSTRAINT fk_ve_employee;
       public          postgres    false    217    3206    219            ?           2606    16701 "   vaccine_employee fk_ve_vaccinetype    FK CONSTRAINT     ?   ALTER TABLE ONLY public.vaccine_employee
    ADD CONSTRAINT fk_ve_vaccinetype FOREIGN KEY (id_vaccine_type) REFERENCES public.vaccinetype(id_vaccine_type);
 L   ALTER TABLE ONLY public.vaccine_employee DROP CONSTRAINT fk_ve_vaccinetype;
       public          postgres    false    212    219    3198            #   ?   x?m??
?0???S???N%;M????.Y)??-R?ŧ?Eß?ǟ? ?]?&B2y5?<? ?8???	N2[?'.]T5?Ӑ???h?Ԙ??m??ķLk?z?p?9???p,????7???I?????7"\ą??~??J)? ?@9?         2   x?3?tL????,.)JL?/?tt????2?t?-?I?p??q??qqq +d      !      x?3?4?2?4?????? ??          h   x?3?,?T1JT14P?*52ȴ4?
q?J4.M43?
?w?vJ6??s+q?7.(6J?ps+???pv???L?KO??wH?M???K???2??Ĭ??$?b???? ?`1      %   6   x?3?4?4202?5??50T04?26?24?r???3?4?2?!g?i????? ??            x?3?st?st??2???W??b???? l=?         P   x?3?,KLN??KUH?/RH?/?L?.(-????2?"?X\R???????e?E> -?*?????WF~^q~???????? ?+J     