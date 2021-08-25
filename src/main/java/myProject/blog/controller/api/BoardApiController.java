package myProject.blog.controller.api;

import lombok.RequiredArgsConstructor;
import myProject.blog.config.auth.PrincipalDetail;
import myProject.blog.dto.board.RequestBoardDto;
import myProject.blog.dto.board.ResponseBoardDto;
import myProject.blog.entity.Board;
import myProject.blog.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final BoardService boardService;

    @PostMapping("/api/board")
    public ResponseBoardDto<?> save(@Valid @RequestBody RequestBoardDto requestBoardDto, @AuthenticationPrincipal PrincipalDetail principal, BindingResult result) throws Exception {
        failResponse(result);
        Board board = boardService.board_Write(requestBoardDto, principal.getUser());

        return new ResponseBoardDto<>(board, HttpStatus.OK);
    }
    private void failResponse(BindingResult result) throws BindException {
        if (result.hasErrors()) {
            throw new BindException(result);
        }
    }

}
