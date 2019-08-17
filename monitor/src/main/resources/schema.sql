CREATE TABLE IF NOT EXISTS public.client(
  client_id SERIAL,
  name character varying(60) NOT NULL,
  isactive boolean NOT NULL,
  created timestamp without time zone NOT NULL DEFAULT now(),
  createdby numeric(10,0) NOT NULL,
  updated timestamp without time zone NOT NULL DEFAULT now(),
  updatedby numeric(10,0) NOT NULL,
  CONSTRAINT client_pkey PRIMARY KEY (client_id)
);

CREATE TABLE IF NOT EXISTS public.users(
  users_id SERIAL,
  client_id integer NOT NULL,
  username character varying(60)  NOT NULL,
  password character varying(1024),
  email character varying(60),
  isactive boolean NOT NULL,
  created timestamp without time zone NOT NULL DEFAULT now(),
  createdby numeric(10,0) NOT NULL,
  updated timestamp without time zone NOT NULL DEFAULT now(),
  updatedby numeric(10,0) NOT NULL,
  CONSTRAINT users_pkey PRIMARY KEY (users_id),
  FOREIGN KEY (client_id) REFERENCES public.client (client_id)
);

CREATE TABLE IF NOT EXISTS public.role(
  role_id SERIAL,
  name character varying(60) NOT NULL,
  client_id integer NOT NULL,
  isactive boolean NOT NULL,
  created timestamp without time zone NOT NULL DEFAULT now(),
  createdby numeric(10,0) NOT NULL,
  updated timestamp without time zone NOT NULL DEFAULT now(),
  updatedby numeric(10,0) NOT NULL,
  CONSTRAINT role_pkey PRIMARY KEY (role_id),
  FOREIGN KEY (client_id) REFERENCES public.client (client_id)
);


CREATE TABLE IF NOT EXISTS public.users_roles
(
  users_id numeric(10,0) NOT NULL,
  role_id integer NOT NULL,
  client_id integer NOT NULL,
  isactive boolean NOT NULL,
  created timestamp without time zone NOT NULL DEFAULT now(),
  createdby numeric(10,0) NOT NULL,
  updated timestamp without time zone NOT NULL DEFAULT now(),
  updatedby numeric(10,0) NOT NULL,
  CONSTRAINT users_roles_pkey PRIMARY KEY (users_id, role_id),
  FOREIGN KEY (client_id) REFERENCES public.client (client_id)
);



INSERT INTO client(
            client_id, name, isactive, created, createdby, updated, updatedby)
    SELECT 0, 'System', true, current_timestamp, 0, current_timestamp, 0
    WHERE NOT EXISTS (SELECT 1 FROM client WHERE client_id = 0);



INSERT INTO users(
            users_id, client_id, username, password, email, isactive, created, 
            createdby, updated, updatedby)
    SELECT 0, 0, 'mainadmin', '$2a$10$W2PdoQeqTSvJAGS6Y.evkuf3L2UpBxKMSr7DsJklS1yX/iWKqN46S', 'mainadmin@company.com', 'Y', current_timestamp, 
            0, current_timestamp, 0
    WHERE NOT EXISTS (SELECT 1 FROM users WHERE users_id = 0);

            
            