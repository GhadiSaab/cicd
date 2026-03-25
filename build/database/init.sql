DROP TABLE IF EXISTS city CASCADE;
DROP SEQUENCE IF EXISTS city_id_seq;

CREATE SEQUENCE city_id_seq START 1;

CREATE TABLE IF NOT EXISTS city (
    id INTEGER PRIMARY KEY DEFAULT nextval('city_id_seq') CHECK (id >= 0),
    department_code VARCHAR(50) NOT NULL,
    insee_code VARCHAR(50),
    zip_code VARCHAR(50),
    name VARCHAR(255) NOT NULL,
    lat DOUBLE PRECISION NOT NULL,
    lon DOUBLE PRECISION NOT NULL
    );


INSERT INTO city (id, department_code, insee_code, zip_code, name, lat, lon)
SELECT * FROM json_populate_recordset(
        NULL::city,
        pg_read_file('/tmp/cities.json')::json
              ) ON CONFLICT (id) DO NOTHING;