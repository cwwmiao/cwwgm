# cwwgm


说明：


  我做的是一个小型的web项目，是一个毕业生管理系统，前端用bootstrap,后端用java实现。简单介绍下需求。就是大四的时候需要选导师，导师也要选学生这是一个互选的过程。导师需要发布课题（可以发布多个），包括了课题的一些要求，还有人数的限制。课题可以查看和修改。当学生选择导师后，老师就可以从选择他的学生中，选择学生，当然不能超过人数限制，这些都是由系统自动控制的。之后老师就可以在平台上下载学生的论文，并且需要进行打分，当然不能重复打分。然后再来说下学生，学生可以查看所有老师给出的课题，然后就能进行选题，一次只能申请一个课题，这是由系统控制的不能重复申请。学生可以查看自己的选题情况，如果选题成功，就会显示课题的所有信息，包括导师姓名和课题要求。如果学生选题失败，就需要重新选题，直到选上为止。写好论文后，就可以上传论文，从而老师可以下载。最后还可以查看自己论文的最终得分。
  
  这个项目做的时间有些紧，感觉可扩展性非常的大。比如说上传资料这块，具体肯定不是上传一个论文就好了，可能需要上传文献翻译，开题报告之类更具体的文件。当然还可以使项目更加完善，一些辅助功能，如个人信息的完善功能，修改密码之类我还没做。
  
  再做一个小的说明，因为一开始我的需求定位就是，账号都是教务处统一给录入数据库的，学生的用户名就是学号，密码初始123456。老师的用户名就是学号，密码初始123456。给一下我线上数据库的测试数据，老师的用户名有test，test2，test3，学生的用户名有stest，stest2...stest7。密码都是123456。
