package evotek.edu.identityservice.exception;

public enum ErrorCode {
  UNCATEGORIZED_EXISTED(9999, "Uncategorized error"),
  INVALID_KEY(1001, " Invalid message key"),
  USER_EXISTED(1002, "User existed 123"),
  USERNAME_INVALID(1003, "Username must be at least 3 charactera"),
  PASSWORD_INVALID(1004, "Password must be at least 3 charactera"),
  USER_NOT_EXISTED(1005, "User not existed"),
  UNAUTHENTICATED(1006, "Unauthenticated");

  ErrorCode(int code, String message) {
    Code = code;
    Message = message;
  }

  private int Code;
  private String Message;

  public int getCode() {
    return Code;
  }

  public void setCode(int code) {
    Code = code;
  }

  public String getMessage() {
    return Message;
  }

  public void setMessage(String message) {
    Message = message;
  }
}
