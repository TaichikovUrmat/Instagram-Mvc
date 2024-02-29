package peaksoft.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Comment;
import peaksoft.service.CommentService;

@Controller
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/newCreateComments/{userID}/{postId}")
  public String createComment(@PathVariable("userID") Long userID, Model model,
                              @PathVariable Long postId){
//        System.out.println("comment 1");
        model.addAttribute("newComment" , new Comment());
//        System.out.println("comment 2");
        model.addAttribute("userID", userID);
//        System.out.println(" comment 3");
        model.addAttribute("postID", postId);
//        System.out.println("comment 4");
        return "createComment";

    }

    @PostMapping("/saveComment/{userID}/{postID}")
    public String saveComment(@ModelAttribute("newComment") Comment comment,
                              @PathVariable("userID") Long userID,
                              @PathVariable("postID") Long postID){
//        System.out.println("comment 5 ");
        commentService.saveComment(userID,postID,comment);
//        System.out.println("comment 6 ");
        return "/createComment";
    }
}
