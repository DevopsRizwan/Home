<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true" CodeBehind="GoToHome.aspx.cs" Inherits="Agreement.GoToHome" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
<strong>Submition Page</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td>
                &nbsp;</td>
        </tr>
        <tr>
            <td style="height: 250px; text-align: center;">
                <h3>Agreement Submitted Succesfully</h3><br />
                
            </td>
        </tr>
        <tr>
            <td style ="text-align :center ;">
                <asp:Button ID="btnGoHome" runat="server" Text="Go To Home" 
                     Font-Size="Large" onclick="btnGoHome_Click" />
            </td>
        </tr>
    </table>
    
</asp:Content>