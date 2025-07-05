
# OPDHeal – Hospital Management System (Microservices Architecture)

**OPDHeal** is a scalable and modular hospital outpatient (OPD) management system built using Spring Boot microservices architecture. It supports doctor-patient appointment booking, prescription handling, secure medical record storage, real-time notifications, and online payment integration.

---

## 🚀 Tech Stack & Tools

| Tech               | Purpose                            |
|--------------------|------------------------------------|
| Java + Spring Boot | Backend microservices              |
| Spring Cloud       | Eureka, Gateway, Config Server     |
| Kafka              | Async communication                |
| Redis              | Caching and session management     |
| MySQL/PostgreSQL   | Relational databases               |
| MongoDB            | Medical records, prescriptions     |
| Docker             | Containerization                   |
| AWS EC2            | Hosting all microservices          |
| AWS S3             | Medical report & file storage      |
| Razorpay/Stripe    | Payment gateway                    |
| Swagger/OpenAPI    | API documentation                  |
| GitHub Actions     | CI/CD Pipeline                     |
| Prometheus + Grafana | Monitoring and alerting          |

---

## 🧩 Microservices Overview

| Service Name            | Description |
|--------------------------|-------------|
| **API Gateway**         | Routes traffic to microservices |
| **Eureka Server**       | Service Discovery               |
| **Config Server**       | Centralized config management   |
| **User Service**        | Manages users (doctors, patients, admins) |
| **Doctor Service**      | Doctor availability, profiles   |
| **Patient Service**     | Patient profiles, health data   |
| **Appointment Service** | Slot booking & schedule mgmt    |
| **Payment Service**     | Payment processing              |
| **Notification Service**| Email/SMS reminders (Kafka)     |
| **Prescription Service**| ePrescription generation        |
| **Medical Records**     | Upload/download from S3         |
| **Analytics Service**   | Admin dashboard, metrics        |

---

## 🌐 System Architecture Diagram

                                     +----------------------+
                                     |     Admin Panel      |
                                     +----------------------+
                                               |
                                               v
+-------------------+         +-------------------+        +-------------------+
|   API Gateway     |<------->|   Eureka Server    |<----->|   Config Server   |
+-------------------+         +-------------------+        +-------------------+
         |                             |                            |
         |                             |                            |
         v                             v                            v
+----------------+     +-------------------+     +------------------------+
| User Service   |     | Doctor Service    |     | Patient Service        |
+----------------+     +-------------------+     +------------------------+
         |                     |                           |
         v                     v                           v
+----------------+   +-------------------+     +------------------------+
| Appointment    |<--> Redis (Slots)     |     | Prescription Service   |
| Service        |   +-------------------+     +------------------------+
         |
         v
+-------------------+       +------------------+
| Payment Service   |<----->| Razorpay/Stripe  |
+-------------------+       +------------------+

         |
         v
+------------------------+
| Notification Service   |
| (Kafka-based)          |
+------------------------+
         |
         v
+------------------------+
| Email/SMS/WhatsApp API |
+------------------------+

         |
         v
+----------------------------+
| Medical Records Service    |
| (PDFs via S3)              |
+----------------------------+

         |
         v
+----------------------------+
| Analytics Service          |
| (Grafana/Prometheus)       |
+----------------------------+

---

## 📦 Project Folder Structure

```
opdheal-parent/
├── api-gateway/
├── config-server/
├── eureka-server/
├── user-service/
├── doctor-service/
├── patient-service/
├── appointment-service/
├── payment-service/
├── notification-service/
├── prescription-service/
├── medical-records-service/
├── analytics-service/
├── docker-compose.yml
├── README.md
└── deployment/
    ├── ec2-setup.sh
    └── s3-policy.json
```

---

## ✅ Features Checklist

- [x] User authentication (JWT + role-based)
- [x] Doctor schedule management
- [x] Appointment booking with advance payment
- [x] Razorpay/Stripe integration
- [x] Asynchronous notifications with Kafka
- [x] Email + WhatsApp/SMS updates
- [x] File upload (lab reports, prescriptions) to AWS S3
- [x] Prometheus/Grafana monitoring dashboard
- [x] REST APIs with Swagger UI

---

## 🔐 Security Features

- Role-Based Access (Admin | Doctor | Patient)
- JWT Authentication
- API Gateway request validation
- Rate limiting and caching (Redis)
- File access with pre-signed S3 URLs

---

## ⚙️ Deployment Steps (EC2 + S3)

1. Launch Ubuntu EC2 instance
2. Install Docker & Docker Compose
3. Clone project and build containers:
   ```bash
   docker-compose up --build
   ```
4. Configure AWS credentials for S3
5. Setup domain + SSL (optional)
6. Monitor logs via Prometheus

---

## 📚 Learning Resources

- [Spring Cloud Docs](https://spring.io/projects/spring-cloud)
- [Kafka in Spring Boot](https://kafka.apache.org/documentation/)
- [AWS S3 Java SDK](https://docs.aws.amazon.com/sdk-for-java/latest/developer-guide/home.html)
- [Dockerizing Java Apps](https://www.baeldung.com/dockerizing-spring-boot-application)

---

## 📌 Future Enhancements

- ✅ Teleconsultation (video chat with Jitsi)
- ✅ Doctor-Prescription AI suggestion
- ✅ PWA frontend for better mobile UX
- ✅ Admin analytics (charts, graphs)

---

## 📝 Kafka cmds

| Task               | Command                         |
| ------------------ | ------------------------------- |
| Start Zookeeper    | `zookeeper-server-start.bat`    |
| Start Kafka Broker | `kafka-server-start.bat`        |
| Create Topic       | `kafka-topics.bat --create ...` |
| Produce Messages   | `kafka-console-producer.bat`    |
| Consume Messages   | `kafka-console-consumer.bat`    |

---

## 👨‍💻 Developed By

**Mahesh Shinde**  
> B.Tech Computer Engineering | Android & Web Developer  
> GitHub: [github.com/coder-mahi](https://github.com/coder-mahi)
> LinkedIn: [linkedin.com/in/maheshshinde](https://linkedin.com/in/maheshshinde)  
> Portfolio: [shindemaheshportfolio.netlify.app](https://shindemaheshportfolio.netlify.app)
