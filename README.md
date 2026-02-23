# TronSync E-Invoicing CRM

A starter full-stack system to maintain customer details for e-invoicing operations, including:
- customer profile management
- meeting scheduling
- NDA / Partnership agreement link generation
- agreement signing workflow tracking

## Tech stack
- Backend: Java 17 + Spring Boot + JPA
- Frontend: React (JavaScript) + Vite
- Database: PostgreSQL

## Database configuration
Backend is preconfigured for:
- host: `3.111.233.209`
- port: `5432`
- database: `tronsync`
- username: `postgres`

Connection properties are in `backend/src/main/resources/application.properties`.

## Run backend
```bash
cd backend
mvn spring-boot:run
```

## Run frontend
```bash
cd frontend
npm install
npm run dev
```

Frontend: `http://localhost:5173`  
Backend: `http://localhost:8080`

## API quick view
- `GET /api/customers`
- `POST /api/customers`
- `POST /api/customers/{id}/meetings`
- `POST /api/customers/{id}/agreements`
- `POST /api/agreements/sign/{token}`
