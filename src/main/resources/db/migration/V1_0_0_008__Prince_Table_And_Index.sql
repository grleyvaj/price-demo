CREATE TABLE "price" (
    "id" INT8 DEFAULT NEXTVAL('sequence_price') PRIMARY KEY,
    "brand_id" INT8 NOT NULL,
    "start_date" TIMESTAMP NOT NULL,
    "end_date" TIMESTAMP NOT NULL,
    "product_id" INT NOT NULL,
    "priority" INT NOT NULL,
    "price" DECIMAL(10, 2) NOT NULL,
    "currency" VARCHAR(3) NOT NULL,
    FOREIGN KEY ("brand_id") REFERENCES "brand"("id"),
    FOREIGN KEY ("product_id") REFERENCES "product"("id")
);

CREATE INDEX "idx_brand_id" ON "brand" ("id");
CREATE INDEX "idx_product_id" ON "product" ("id");