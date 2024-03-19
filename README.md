Prueba Técnica: Cupón de Compra

Este proyecto implementa una API REST para calcular los ítems que un usuario puede comprar utilizando un cupón de compra en una plataforma similar a Mercado Libre.

 Requisitos

- Java JDK 11 o superior
- Maven 3.6.3 o superior (si se utiliza Maven)
- Git
- Postman (opcional, para probar la API)

 Ejecución

1. Clona este repositorio en tu máquina local:

    ```bash
    git clone https://github.com/tu-usuario/prueba-tecnica-cupon.git
    ```

2. Accede al directorio del proyecto:

    ```bash
    cd prueba-tecnica-cupon
    ```

3. Ejecuta la aplicación Spring Boot con Maven:

    ```bash
    mvn spring-boot:run
    ```

   La aplicación se ejecutará en https://github.com/dfc201692/Challenge_Cupon_de_compra

4. Puedes probar la API utilizando Postman o cualquier otra herramienta similar enviando solicitudes a los endpoints `/coupon/` y `/coupon/stats`.

 Uso

 1. Obtener ítems para un cupón

- **Endpoint:** POST `/coupon/`
- **Cuerpo de la solicitud:**

    ```json
    {
        "item_ids": ["MLA1", "MLA2", "MLA3", "MLA4", "MLA5"],
        "amount": 500
    }
    ```

- **Respuesta exitosa:**

    ```json
    {
        "item_ids": ["MLA1", "MLA2", "MLA4", "MLA5"],
        "total": 480.0
    }
    ```

 2. Obtener los ítems más favoritos

- **Endpoint:** GET `/coupon/stats`
- **Respuesta exitosa:**

    ```json
    [
        {
            "id": "MLA1",
            "quantity": 15
        },
        {
            "id": "MLA2",
            "quantity": 10
        },
        {
            "id": "MLA3",
            "quantity": 8
        },
        {
            "id": "MLA4",
            "quantity": 5
        },
        {
            "id": "MLA5",
            "quantity": 3
        }
    ]
    ```
