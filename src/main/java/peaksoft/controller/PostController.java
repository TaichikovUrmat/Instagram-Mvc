package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Post;
import peaksoft.entity.User;
import peaksoft.service.PostService;
import peaksoft.service.UserService;


@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

private final PostService postService;
private final UserService userService;

    @GetMapping("/newPost/{userID}")
    public String createPost(@PathVariable("userID") Long userId,
                             Model model)  { //@RequestParam, @RequestBody
        Post post = new Post();
        model.addAttribute("newPost", post);
        model.addAttribute("userID", userId);
//        model.addAttribute("imageUrl", imageUrl);
        return "/newCreatePost";
    }

    @PostMapping("/savePost/{userID}")
    public String savePost(@ModelAttribute("newPost") Post post,
                           @PathVariable("userID") Long userId,
                           Model model) throws Exception {
        User user = userService.findByUserId(userId);

        model.addAttribute("postInfo", user.getPosts());
        postService.savePostByUser(userId,post);
        return "/postImege";
//             return "/instaProfil";
    }

    @GetMapping("/delete/{postID}")
    public String deletePost(@PathVariable("postID") Long postID
                            )throws Exception {
        Long userID = postService.findPostById(postID).getUser().getId();
//        Post postById = postService.findPostById(postID);
        postService.delete(postID);
      return "/instaProfil" +userID;
    }

}
