package ua.khpi.pinecone.lab2;

public class Engine {
    private Integer code;
    private String engineType;
    private Integer frequency;
    private Integer power;

    public Engine(Integer code, String engineType, Integer frequency, Integer power) {
        this.code = code;
        this.engineType = engineType;
        this.frequency = frequency;
        this.power = power;
    }

    public Integer getCode() {
        return code;
    }

    public String getEngineType() {
        return engineType;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public Integer getPower() {
        return power;
    }
}
