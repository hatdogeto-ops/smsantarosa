-- WARNING: This schema is for context only and is not meant to be run.
-- Table order and constraints may not be valid for execution.

CREATE TABLE public.tasks (
                              id bigint GENERATED ALWAYS AS IDENTITY NOT NULL,
                              created_at timestamp with time zone NOT NULL DEFAULT now(),
                              text character varying,
                              deadline date,
                              status boolean DEFAULT false,
                              user_id bigint,
                              CONSTRAINT tasks_pkey PRIMARY KEY (id),
                              CONSTRAINT tasks_user_id_fkey FOREIGN KEY (user_id) REFERENCES public.users(id)
);
CREATE TABLE public.users (
                              id bigint GENERATED ALWAYS AS IDENTITY NOT NULL,
                              created_at timestamp with time zone NOT NULL DEFAULT now(),
                              name character varying NOT NULL,
                              password character varying NOT NULL,
                              CONSTRAINT users_pkey PRIMARY KEY (id)
);