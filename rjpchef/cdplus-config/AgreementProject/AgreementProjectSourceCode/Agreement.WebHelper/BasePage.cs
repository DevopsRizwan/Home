/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Agreement.BusinessEntity;

namespace Agreement.WebHelper
{
    public class BasePage : System.Web.UI.Page
    {
        public UsersEntity UserInfo { get; set; }

        protected override void OnPreLoad(EventArgs e)
        {
            if (SessionManager.UsersEntity == null)
            {
                Response.Redirect("loginpage.aspx?msg=Session Expired, please login again.", true);
            }
            //UserInfo = new UsersEntity() { UserID = 5, UserName = "xxxxx", FirstName = "F Name 1" };
            //Session["UsersID"] = UserInfo.UserID;
            base.OnPreLoad(e);
        }



    }
}
