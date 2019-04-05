package com.hai.xsmb.core.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RESULT")
public class ResultEntity extends AbstractEntity{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer first;

    @Column(nullable = false)
    private Integer second;

    @Column(nullable = false)
    private Integer third1;

    @Column(nullable = false)
    private Integer third2;

    @Column(nullable = false)
    private Integer fourth1;

    @Column(nullable = false)
    private Integer fourth2;

    @Column(nullable = false)
    private Integer fourth3;

    @Column(nullable = false)
    private Integer fourth4;

    @Column(nullable = false)
    private Integer fourth5;

    @Column(nullable = false)
    private Integer fourth6;

    @Column(nullable = false)
    private Integer fifth1;

    @Column(nullable = false)
    private Integer fifth2;

    @Column(nullable = false)
    private Integer fifth3;

    @Column(nullable = false)
    private Integer fifth4;

    @Column(nullable = false)
    private Integer sixth1;

    @Column(nullable = false)
    private Integer sixth2;

    @Column(nullable = false)
    private Integer sixth3;

    @Column(nullable = false)
    private Integer sixth4;

    @Column(nullable = false)
    private Integer sixth5;

    @Column(nullable = false)
    private Integer sixth6;

    @Column(nullable = false)
    private Integer seventh1;

    @Column(nullable = false)
    private Integer seventh2;

    @Column(nullable = false)
    private Integer seventh3;

    @Column(nullable = false)
    private Integer eighth1;

    @Column(nullable = false)
    private Integer eighth2;

    @Column(nullable = false)
    private Integer eighth3;

    @Column(nullable = false)
    private Integer eighth4;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, length = 10, unique = true)
    private Date date;

    public ResultEntity() {
    }


    public ResultEntity(Integer first, Integer second, Integer third1, Integer third2, Integer fourth1, Integer fourth2, Integer fourth3, Integer fourth4, Integer fourth5, Integer fourth6,
                        Integer fifth1, Integer fifth2, Integer fifth3, Integer fifth4, Integer sixth1, Integer sixth2, Integer sixth3, Integer sixth4, Integer sixth5, Integer sixth6,
                        Integer seventh1, Integer seventh2, Integer seventh3, Integer eighth1, Integer eighth2, Integer eighth3, Integer eighth4) {
        this.first = first;
        this.second = second;
        this.third1 = third1;
        this.third2 = third2;
        this.fourth1 = fourth1;
        this.fourth2 = fourth2;
        this.fourth3 = fourth3;
        this.fourth4 = fourth4;
        this.fourth5 = fourth5;
        this.fourth6 = fourth6;
        this.fifth1 = fifth1;
        this.fifth2 = fifth2;
        this.fifth3 = fifth3;
        this.fifth4 = fifth4;
        this.sixth1 = sixth1;
        this.sixth2 = sixth2;
        this.sixth3 = sixth3;
        this.sixth4 = sixth4;
        this.sixth5 = sixth5;
        this.sixth6 = sixth6;
        this.seventh1 = seventh1;
        this.seventh2 = seventh2;
        this.seventh3 = seventh3;
        this.eighth1 = eighth1;
        this.eighth2 = eighth2;
        this.eighth3 = eighth3;
        this.eighth4 = eighth4;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getThird1() {
        return third1;
    }

    public void setThird1(Integer third1) {
        this.third1 = third1;
    }

    public Integer getThird2() {
        return third2;
    }

    public void setThird2(Integer third2) {
        this.third2 = third2;
    }

    public Integer getFourth1() {
        return fourth1;
    }

    public void setFourth1(Integer fourth1) {
        this.fourth1 = fourth1;
    }

    public Integer getFourth2() {
        return fourth2;
    }

    public void setFourth2(Integer fourth2) {
        this.fourth2 = fourth2;
    }

    public Integer getFourth3() {
        return fourth3;
    }

    public void setFourth3(Integer fourth3) {
        this.fourth3 = fourth3;
    }

    public Integer getFourth4() {
        return fourth4;
    }

    public void setFourth4(Integer fourth4) {
        this.fourth4 = fourth4;
    }

    public Integer getFourth5() {
        return fourth5;
    }

    public void setFourth5(Integer fourth5) {
        this.fourth5 = fourth5;
    }

    public Integer getFourth6() {
        return fourth6;
    }

    public void setFourth6(Integer fourth6) {
        this.fourth6 = fourth6;
    }

    public Integer getFifth1() {
        return fifth1;
    }

    public void setFifth1(Integer fifth1) {
        this.fifth1 = fifth1;
    }

    public Integer getFifth2() {
        return fifth2;
    }

    public void setFifth2(Integer fifth2) {
        this.fifth2 = fifth2;
    }

    public Integer getFifth3() {
        return fifth3;
    }

    public void setFifth3(Integer fifth3) {
        this.fifth3 = fifth3;
    }

    public Integer getFifth4() {
        return fifth4;
    }

    public void setFifth4(Integer fifth4) {
        this.fifth4 = fifth4;
    }

    public Integer getSixth3() {
        return sixth3;
    }

    public void setSixth3(Integer sixth3) {
        this.sixth3 = sixth3;
    }

    public Integer getSixth4() {
        return sixth4;
    }

    public void setSixth4(Integer sixth4) {
        this.sixth4 = sixth4;
    }

    public Integer getSixth5() {
        return sixth5;
    }

    public void setSixth5(Integer sixth5) {
        this.sixth5 = sixth5;
    }

    public Integer getSixth6() {
        return sixth6;
    }

    public void setSixth6(Integer sixth6) {
        this.sixth6 = sixth6;
    }

    public Integer getSeventh1() {
        return seventh1;
    }

    public void setSeventh1(Integer seventh1) {
        this.seventh1 = seventh1;
    }

    public Integer getSeventh2() {
        return seventh2;
    }

    public void setSeventh2(Integer seventh2) {
        this.seventh2 = seventh2;
    }

    public Integer getSeventh3() {
        return seventh3;
    }

    public void setSeventh3(Integer seventh3) {
        this.seventh3 = seventh3;
    }

    public Integer getEighth1() {
        return eighth1;
    }

    public void setEighth1(Integer eighth1) {
        this.eighth1 = eighth1;
    }

    public Integer getEighth2() {
        return eighth2;
    }

    public void setEighth2(Integer eighth2) {
        this.eighth2 = eighth2;
    }

    public Integer getEighth3() {
        return eighth3;
    }

    public void setEighth3(Integer eighth3) {
        this.eighth3 = eighth3;
    }

    public Integer getEighth4() {
        return eighth4;
    }

    public void setEighth4(Integer eighth4) {
        this.eighth4 = eighth4;
    }

    public Integer getSixth1() {
        return sixth1;
    }

    public void setSixth1(Integer sixth1) {
        this.sixth1 = sixth1;
    }

    public Integer getSixth2() {
        return sixth2;
    }

    public void setSixth2(Integer sixth2) {
        this.sixth2 = sixth2;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
