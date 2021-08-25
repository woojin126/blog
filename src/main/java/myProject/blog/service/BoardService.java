package myProject.blog.service;

import lombok.RequiredArgsConstructor;
import myProject.blog.dto.board.RequestBoardDto;
import myProject.blog.entity.Board;
import myProject.blog.entity.User;
import myProject.blog.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;


    @Transactional
    public Board board_Write(RequestBoardDto requestBoardDto, User user){
        requestBoardDto.setCount(0);
        requestBoardDto.setUser(user);

        return boardRepository.save(requestBoardDto.toEntity());
    }
}
