package peaksoft.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import peaksoft.entity.User;
import peaksoft.service.FollowerService;
import peaksoft.service.PostService;
import peaksoft.service.UserService;

@Controller
@RequestMapping("follower")
@RequiredArgsConstructor
public class FollowerController {
    private final FollowerService followerService;
    private final UserService userService;
    private final PostService postService;
    @GetMapping("/newSearch/{userId}")
    public String findUser(@PathVariable Long userId,Model model)  {
        model.addAttribute("userID",userId);
//        model.addAttribute("userId",userService.findByUserId(userId).getId());
        return "search";
    }

    @GetMapping("/searchUser/{userId}")
    public String search(Model model,
                         @RequestParam("searchName") String searchName,
                         @PathVariable Long userId){
        try{
        User user = userService.findUserByName(searchName);
        model.addAttribute("user",user);
        model.addAttribute("userIDD",userId);

        model.addAttribute("subcribers", followerService.Subscribers(user.getFollower().getId()));
        model.addAttribute("subcribtions", followerService.Subscriptions(user.getFollower().getId()));
        model.addAttribute("post",postService.getAllPostByUserId(user.getId()).size());
        return "foundUser";
        }catch (Exception e){
             return "search";
      }
    }
    @GetMapping("/follow/{currentUserId}/{foundUserId}")
    public String following(Model model,@PathVariable Long foundUserId,
                            @PathVariable Long currentUserId ) throws Exception {

        followerService.following(currentUserId,foundUserId);
        model.addAttribute("foundUserId",foundUserId);
        model.addAttribute("currentUser",currentUserId);
        

        model.addAttribute("subcribers", followerService.Subscribers(userService.findByUserId(currentUserId).getFollower().getId()));
        model.addAttribute("subcribtions", followerService.Subscriptions(userService.findByUserId(currentUserId).getFollower().getId()));
        model.addAttribute("post",postService.getAllPostByUserId(currentUserId).size());
        return "foundUser";
    }

}
