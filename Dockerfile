# Usar una imagen base de GraalVM con soporte para Java 21
FROM ghcr.io/graalvm/graalvm-ce:java21-22.3.0 as build

# Instalar Maven (si es necesario)
RUN gu install native-image

# Establecer directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto
COPY . .

# Compilar el proyecto usando Maven
RUN ./mvnw clean package -DskipTests

# Generar la imagen nativa de GraalVM
RUN ./mvnw -Pnative package

# Usar una imagen más ligera para correr la aplicación
FROM ghcr.io/graalvm/graalvm-ce:java21-22.3.0

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar la aplicación compilada desde la etapa de construcción
COPY --from=build /app/target/my-app /app/my-app

# Hacer el binario ejecutable
RUN chmod +x /app/my-app

# Exponer el puerto que usa la aplicación
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["./my-app"]