package CollectionObjects;

import java.io.Serializable;

public enum Status implements Serializable {
    OK ("Запрос успешно выполнен"),
    REQUEST_ERROR ("Ошибка обработки запроса"),
    CONNECTION_ERROR ("Ошибка соединения");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
