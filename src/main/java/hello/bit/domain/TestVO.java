package hello.bit.domain;

import lombok.Data;

@Data
public class TestVO{

    private Long memberNo;
    private String id;
    private String name;

    public TestVO( String id , String name ){
        this.id = id;
        this.name = name;
    }

}
