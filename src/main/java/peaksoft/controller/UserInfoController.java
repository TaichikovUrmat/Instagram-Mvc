package peaksoft.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.entity.Comment;
import peaksoft.entity.User;
import peaksoft.entity.UserInfo;
import peaksoft.service.CommentService;
import peaksoft.service.PostService;
import peaksoft.service.UserInfoService;
import peaksoft.service.UserService;

@Controller
@RequestMapping("/userInfo")
@RequiredArgsConstructor
public class UserInfoController {

    private final  UserInfoService userInfoService;
    private final PostService postService;
    private final UserService userService;
    private  final CommentService commentService;

    ////*****************************  home  *********************************************////
    @GetMapping("/home")
    public String ribbon(@ModelAttribute Model model,Long postID){
        System.out.println("comment  hom 1 ");
        model.addAttribute("allPost",postService.getAll());
        System.out.println("comment  hom 2 ");
        model.addAttribute("comments");
        System.out.println("comment  hom 3 ");
        model.addAttribute("postID",postService.findPostById(postID));
//        userID
        return "home-page";
    }

    ////***************************** instaProfile  *********************************************////

    @GetMapping("/newInstaProfile/{userId}")
    public String instaProfile(@PathVariable("userId") Long userId,Long commentID,Model model) throws Exception {
        User user = userService.findByUserId(userId);
        Comment comment = new Comment();
        model.addAttribute("userId", userId);
        model.addAttribute("user", userService.findByUserId(userId));
        model.addAttribute("userInfo",userInfoService.findUserInfoByUserID(userId));
        model.addAttribute("postInfo", user.getPosts());
        model.addAttribute("commentInfo",comment);
        return "/instaProfil";
    }
 ////***************************** update Info *********************************************////

    @GetMapping("/update/{userInfoId}")
    public String updateUserInfo(@PathVariable("userInfoId") Long userInfoId, Model model){
        UserInfo userInfo = userInfoService.findById(userInfoId);
        model.addAttribute("newUserInfo", userInfo);
        model.addAttribute("userInfoId", userInfoId);
        return "createUserInfo";
    }
    @PostMapping("/edit/{userInfoId}")
    public String editUserInfo(@ModelAttribute("userInfo") UserInfo userInfo,
                               @PathVariable Long userInfoId){
        userInfoService.update(userInfoId,userInfo);
        return "redirect:/instaProfil";
    }
/////*********************** Delete **************************************///

//    @GetMapping("/delete/{userInfoId}")
//    public String deleteUserInfo(@ModelAttribute("newUserInfo")
//            @PathVariable("userInfoId") Long userInfoID) throws Exception {
//        Long userId = userService.findByUserId(userInfoID).getUserInfo().getId();
//        userInfoService.delete(userInfoID);
//        return "redirect:/userInfo/newInstaProfile/" + userId;
//    }
//
  ////******************* Update ***************************************////

//    @GetMapping("/update/{userID}")
//    public String updateUserInfoCreate(@PathVariable("userInfoID")Long userInfoId,Model model) throws Exception {
//        UserInfo userInfoByUserID = userInfoService.findUserInfoByUserID(userInfoId);
//        model.addAttribute("userInfoByUserID", userInfoByUserID);
//        return "updateUserInfo";
//    }
//    @PostMapping("/editUpdate/{userInfoID}")
//    public  String updateUserInfo(@ModelAttribute("userInfoByUserID") UserInfo userInfo,
//                                  @PathVariable("userInfoID")Long userInfoId){
//        System.out.println("userInfoId = " + userInfoId);
//        userInfoService.update(userInfoId,userInfo);
//    return "/updateUserInfo";
//        }
    }



