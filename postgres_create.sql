CREATE TABLE "public.users" (
	"id" serial NOT NULL,
	"username" varchar(255) NOT NULL UNIQUE,
	"email" varchar(255) NOT NULL UNIQUE,
	"profile_photo" varchar(255) NOT NULL,
	"password" varchar(32) NOT NULL,
	"display_name" varchar(255) NOT NULL,
	CONSTRAINT "users_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);



CREATE TABLE "public.tasks" (
	"id" serial NOT NULL,
	"user_id" serial NOT NULL,
	"title" varchar(255) NOT NULL,
	"description" TEXT,
	"date_created" DATE NOT NULL,
	"due_date" DATE,
	CONSTRAINT "tasks_pk" PRIMARY KEY ("id")
) WITH (
  OIDS=FALSE
);




ALTER TABLE "tasks" ADD CONSTRAINT "tasks_fk0" FOREIGN KEY ("user_id") REFERENCES "users"("id");



