package umc.week7.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.week7.apiPayload.code.BaseCode;
import umc.week7.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    /*
    @JsonProperty는 Java 객체와 Json 간의 직렬화 또는 역직렬화시 이름을 사용하고 싶을 때 사용.
    그럼 직렬화, 역직렬화는 뭘까?
    ->

    그리고 그냥 해당 annotation만 쓰면 여기서 쓸 수 없다는 오류가 난다.
    이건 이제 기본 생성자가 없어서다.
    일반적으로 Jackson 라이브러리는 역직렬화를 위해 기본 생성자를 필요로 한다.
    근데 Lombok의 @AllArgsConstructor 어노테이션이 생성자를 만들어 주지 않나? 할 수 있음.
    아마도 아무것도 안쓰니 필드가 비어있어 생성자를 만들 수 없어서 그런 거 같다.
    */
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;

    // 성공한 경우 응답 생성

        public static <T> ApiResponse<T> onSuccess(T result){
            return new ApiResponse<>(true, SuccessStatus._OK.getCode() , SuccessStatus._OK.getMessage(), result);
        }

        public static <T> ApiResponse<T> of(BaseCode code, T result){
                return new ApiResponse<>(true, code.getReasonHttpStatus().getCode() , code.getReasonHttpStatus().getMessage(), result);
        }

    // 실패한 경우 응답 생성
    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        return new ApiResponse<>(true, code, message, data);
    }

}
