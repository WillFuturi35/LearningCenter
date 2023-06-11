package com.acme.learningcenter.learning.mapping;

public class MappingConfiguration {
    public  StudentMapper studentMapper() {
        return new StudentMapper();
    }

    public SkillMapper skillMapper(){
        return  new SkillMapper();
    }
}
