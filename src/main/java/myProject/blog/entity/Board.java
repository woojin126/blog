package myProject.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import myProject.blog.entity.timesupperclass.DatabaseEntity;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.util.List;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board extends DatabaseEntity {

    @Id
    @GeneratedValue
    @Column(name = "board_Id")
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;
    
    @Lob //대용량 데이터
    private String content; //섬머노트 라이브러리 <html> 섞여서 디자인됨

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_Id")
    private User user;

    @OneToMany(mappedBy = "board")
    private List<Reply> replyList;
}
