<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Work.aspx.cs" Inherits="Agreement.Work" %>

<%@ Register Src="Navigator.ascx" TagName="Navigator" TagPrefix="uc1" %>
<%@ Register src="UserControls/WorkControl.ascx" tagname="WorkControl" tagprefix="uc2" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
    </asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <b>Work</b>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <%--<tr>
            <td>
               
                <uc1:Navigator ID="Navigator1" runat="server" />
               
            </td>
        </tr>--%>
        <tr>
            <td>
            
                <uc2:WorkControl ID="WorkControl1" runat="server" />
            
            </td>
        </tr>
    </table>
   <%-- <script language="javascript" type="text/javascript">

        function validate() {

            //                    $('#<%=txtServiceDescription.ClientID%>').val();
            //                    $('#<%=txtServiceDescription.ClientID%>').val('test');
            //                    $('input[name="txtsome"]').val('test');

            if (document.getElementById("<%=txtServiceDescription.ClientID%>").value == "") {
                alert("Name Feild can not be blank");
                document.getElementById("<%=txtServiceDescription.ClientID%>").focus();
                return false;
            }
            return true;
        }
    </script>--%>
</asp:Content>
