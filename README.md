# 🚀 Spring Batch ETL Processor - Excelencia en Procesamiento por Lotes

<div align="center">
  <img src="https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java">
  <img src="https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Boot">
  <img src="https://img.shields.io/badge/Spring_Batch-6DB33F?style=for-the-badge&logo=spring&logoColor=white" alt="Spring Batch">
  <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL">
</div>

![Demo Preview](https://github.com/Yilver7u7/java-batch/blob/main/src/main/resources/static/batch-process.png?raw=true)

## 🌟 Descripción del Proyecto
**Spring Batch ETL Processor** es una solución robusta para procesamiento por lotes que demuestra:

- � **ETL Completo**: Extracción, Transformación y Carga de datos desde archivos ZIP/CSV
- 🚀 **Arquitectura Escalable**: Diseñada para manejar grandes volúmenes de datos
- ⚡ **Spring Batch 5**: Utilizando las últimas características del framework
- 🔄 **Procesamiento Paralelo**: Optimizado para máximo rendimiento
- 📊 **Persistencia en MySQL**: Almacenamiento seguro de resultados

## 🛠️ Tecnologías Clave

| Categoría          | Tecnologías                                                                 |
|---------------------|-----------------------------------------------------------------------------|
| **Backend**        | ![Java 17](https://img.shields.io/badge/-Java%2017-ED8B00?logo=openjdk) ![Spring Boot 3](https://img.shields.io/badge/-Spring%20Boot%203-6DB33F?logo=spring) |
| **Procesamiento**  | ![Spring Batch](https://img.shields.io/badge/-Spring%20Batch-6DB33F?logo=spring) |
| **Base de Datos**  | ![MySQL](https://img.shields.io/badge/-MySQL-4479A1?logo=mysql&logoColor=white) |
| **Herramientas**   | ![Lombok](https://img.shields.io/badge/-Lombok-000?logo=lombok) ![OpenCSV](https://img.shields.io/badge/-OpenCSV-6DB33F) |

## 🎯 Características Principales

- 📦 **Procesamiento de Archivos ZIP**: Descompresión automática de lotes
- 📄 **Lectura de CSV**: Parseo eficiente con OpenCSV
- 🧠 **Transformación de Datos**: Enriquecimiento con metadatos de procesamiento
- 💾 **Persistencia Batch**: Escritura optimizada en base de datos
- 🔄 **Control de Transacciones**: Garantía de integridad de datos
- 📈 **Monitoreo**: Seguimiento completo del proceso

- # 📊 Flujo del Proceso Batch
- **Upload:** Subida de archivos ZIP vía API REST

- **Descompresión:** Extracción automática de contenidos

- **Lectura:** Procesamiento de archivos CSV

- **Transformación:** Enriquecimiento de datos

- **Persistencia:** Almacenamiento en base de datos

## 🚀 Guía Rápida de Instalación

```bash
# 1. Clona el repositorio
git clone https://github.com/Yilver7u7/java-batch.git

# 2. Configura la base de datos (MySQL)
CREATE DATABASE batch_database;
GRANT ALL PRIVILEGES ON batch_database.* TO 'batch_user'@'localhost' IDENTIFIED BY 'batch_pass';

# 3. Configura las variables en application.properties
# Archivo de configuracion de ejemplo
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/batch_database
spring.datasource.username=root
spring.datasource.password=your_password

# Configuración Spring Batch
spring.batch.initialize-schema=always
spring.batch.jdbc.table-prefix=BATCH_

# 4. Ejecuta la aplicación
mvn spring-boot:run

# 5. Envía archivos via API
POST http://localhost:8080/v1/uploadFile
