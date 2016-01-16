<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Eligibility.aspx.cs" Inherits="Agreement.Eligibility" %>

<%@ Register Src="Navigator.ascx" TagName="Navigator" TagPrefix="uc1" %>
<%@ Register src="UserControls/EligibilityControl.ascx" tagname="EligibilityControl" tagprefix="uc2" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Eligibility List</strong>
    
  
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
             
                <uc2:EligibilityControl ID="EligibilityControl1" runat="server" />
             
            </td>
        </tr>
    </table>
</asp:Content>
