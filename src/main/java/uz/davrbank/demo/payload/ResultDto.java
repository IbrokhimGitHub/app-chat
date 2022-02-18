package uz.davrbank.demo.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultDto {
    private String message;
    private boolean success;
    private Object object;

    public ResultDto(String message, boolean success) {
        this.message = message;
        this.success = success;
    }
}
