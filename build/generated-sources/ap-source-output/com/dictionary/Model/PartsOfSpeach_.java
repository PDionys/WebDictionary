package com.dictionary.Model;

import com.dictionary.Model.Meanings;
import com.dictionary.Model.Words;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-05-15T17:08:11")
@StaticMetamodel(PartsOfSpeach.class)
public class PartsOfSpeach_ { 

    public static volatile SingularAttribute<PartsOfSpeach, Words> wId;
    public static volatile CollectionAttribute<PartsOfSpeach, Meanings> meaningsCollection;
    public static volatile SingularAttribute<PartsOfSpeach, String> pof;
    public static volatile SingularAttribute<PartsOfSpeach, BigDecimal> pofId;

}