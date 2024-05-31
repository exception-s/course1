package CollectionObjects;

import java.io.Serializable;

public enum Status implements Serializable {
    OK ("Запрос успешно выполнен"),
    REQUEST_ERROR ("Ошибка обработки запроса"),
    USER_ERROR("Пользовательская ошибка"),
    USER_IS_REGISTERED("Пользователь зарегистрирован"),
    USER_IS_NOT_REGISTERED("Пользователь не зарегистрирован"),
    INCORRECT_PASSWORD("Неверный пароль"),
    CONNECTION_ERROR ("Ошибка соединения");

    private final String message;

    Status(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
