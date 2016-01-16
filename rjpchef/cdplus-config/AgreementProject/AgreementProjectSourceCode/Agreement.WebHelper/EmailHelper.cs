/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Net.Mail;
using System.Configuration;
using System.IO;

namespace Agreement.WebHelper
{
    public class EmailHelper
    {
        public static void SendEmail(List<string> toEmail, string subject, string body, List<string> ccEmail = null)
        {
            
         
            //send email
            MailMessage mailMessage = new MailMessage();

            mailMessage.From = new MailAddress(ConfigurationManager.AppSettings["FromEmail"], ConfigurationManager.AppSettings["displayName"]);
            /*Adding TO emails*/
            foreach (var toEmailId in toEmail)
            {
                mailMessage.To.Add(new MailAddress(toEmailId));
            }
            /*Adding CC emails*/
            if (ccEmail != null)
            {
                foreach (var ccEmailId in ccEmail)
                {
                    mailMessage.CC.Add(new MailAddress(ccEmailId));
                }
            }

            mailMessage.Subject = subject;
            mailMessage.Body = body;
            mailMessage.IsBodyHtml = true;

            SmtpClient smtpClient = new SmtpClient(ConfigurationManager.AppSettings["smtpServer"], Convert.ToInt32(ConfigurationManager.AppSettings["smtpPort"]));
            smtpClient.Credentials = new System.Net.NetworkCredential()
            {
                UserName = ConfigurationManager.AppSettings["userId"],
                Password = ConfigurationManager.AppSettings["password"]
            };
            smtpClient.EnableSsl = true;
            smtpClient.Send(mailMessage);
        }
    }
}
