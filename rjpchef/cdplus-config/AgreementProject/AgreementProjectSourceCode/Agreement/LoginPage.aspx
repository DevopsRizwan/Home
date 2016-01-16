<%@ Page Title="" Language="C#" MasterPageFile="~/LoginMaster.Master" AutoEventWireup="true" CodeBehind="LoginPage.aspx.cs" Inherits="Agreement.LoginPage" %>
<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Login</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table>
    <tr>
    <td>
        <asp:Label ID="lblMsg" runat="server" ></asp:Label></td>
    </tr>
<tr>
<td style="height:60px">

    <strong>Username</strong> <br />
    <asp:TextBox ID="txtUserName" runat="server" Width="220px" Height="25px"></asp:TextBox>
    <asp:RequiredFieldValidator ID="valReqUsername" runat="server" 
        ErrorMessage="Please enter Username" SetFocusOnError="true" 
        ValidationGroup="Signin" ForeColor="Red" Display="Dynamic" 
        ControlToValidate="txtUserName"></asp:RequiredFieldValidator>
</td>
</tr>

<tr>
<td style="height:60px">
    <strong>Password</strong> <br />
    <asp:TextBox ID="txtPassword" runat="server" Width="220px" Height="25px" 
        TextMode="Password"></asp:TextBox>
    <asp:RequiredFieldValidator ID="valReqPassword" runat="server" 
        ErrorMessage="Please enter Password" SetFocusOnError="true" 
        ValidationGroup="Signin" ForeColor="Red" Display="Dynamic" 
        ControlToValidate="txtPassword"></asp:RequiredFieldValidator>
</td>
</tr>
<tr>
<td style="height:60px">
    <asp:Button ID="btnSignin" runat="server" Text="Sign in" 
        onclick="btnSignin_Click" ValidationGroup="Signin" />
</td>
</tr>
</table>
</asp:Content>
