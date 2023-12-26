CREATE TABLE "brand" (
    "id" INT8 DEFAULT NEXTVAL('sequence_brand') PRIMARY KEY,
    "name" VARCHAR(100) NOT NULL,
    "country_code" VARCHAR(3) NOT NULL,
    "sector" VARCHAR(100),
    "created_at" TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
);