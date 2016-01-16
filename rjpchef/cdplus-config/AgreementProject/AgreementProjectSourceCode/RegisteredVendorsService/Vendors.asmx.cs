/*
Developed by Vasu R
http://www.onlinetrainingdotnet.com
*/
using System;
using System.Collections.Generic;
using System.Web;
using System.Web.Services;
using System.Data;
using System.Data.SqlClient;
using System.Configuration;

namespace RegisteredVendorsService
{
    /// <summary>
    /// Summary description for Vendors
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]

    public class Vendors : System.Web.Services.WebService
    {

        [WebMethod]
        public string HelloWorld()
        {
            return "Hello All...";
        }

        [WebMethod]
        public DataSet GetVendorByID(int vendorId)
        {
            string Connectionstring = ConfigurationManager.ConnectionStrings["DbConn"].ToString();
            SqlConnection objconnection = new SqlConnection(Connectionstring);
            objconnection.Open();

            //fire command object
            SqlCommand objcommand = new SqlCommand("select * from Vendor where VendorID =" + vendorId, objconnection);
            DataSet objDataSet = new DataSet();
            SqlDataAdapter objAdapter = new SqlDataAdapter(objcommand);
            objAdapter.Fill(objDataSet);

            //bind the data to UI
            // 


            //closed connection
            objconnection.Close();
            return objDataSet;
        }

        [WebMethod]
        public DataSet GetVendorList()
        {
            string Connectionstring = ConfigurationManager.ConnectionStrings["DbConn"].ToString();
            SqlConnection objconnection = new SqlConnection(Connectionstring);
            objconnection.Open();

            //fire command object
            SqlCommand objcommand = new SqlCommand("select VendorID, Name from Vendor", objconnection);
            DataSet objDataSet = new DataSet();
            SqlDataAdapter objAdapter = new SqlDataAdapter(objcommand);
            objAdapter.Fill(objDataSet);

            //bind the data to UI
            // 


            //closed connection
            objconnection.Close();
            return objDataSet;
        }


    }
}
