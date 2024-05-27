package com.dictionary.Model;

import com.dictionary.Model.PartsOfSpeach;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.9.v20210604-rNA", date="2024-05-15T17:08:11")
@StaticMetamodel(Words.class)
public class Words_ { 

    public static volatile SingularAttribute<Words, BigDecimal> wId;
    public static volatile CollectionAttribute<Words, PartsOfSpeach> partsOfSpeachCollection;
    public static volatile SingularAttribute<Words, String> word;

}