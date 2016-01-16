<%@ Page Title="" Language="C#" MasterPageFile="~/AgreementMaster.Master" AutoEventWireup="true"
    CodeBehind="Status.aspx.cs" Inherits="Agreement.Status" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" runat="server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="contentPlsHldrMainPageTitle" runat="server">
    <strong>Status Page</strong>
</asp:Content>
<asp:Content ID="Content3" ContentPlaceHolderID="contentPlsHldrMain" runat="server">
    <table width="100%">
        <tr>
            <td>
                <asp:GridView ID="gvStatus" runat="server" AutoGenerateColumns="false" HeaderStyle-CssClass="headertext"
                    RowStyle-CssClass="rowstyle" Width="100%" 
                    onrowdatabound="gvStatus_RowDataBound" >
                    <Columns>
                        <asp:BoundField HeaderText="Sr. No" DataField="Sno" ItemStyle-Width="10%" HeaderStyle-HorizontalAlign="Left" />
                        <asp:BoundField HeaderText="Item" DataField="Item" HeaderStyle-HorizontalAlign="Left" />
                        <asp:BoundField HeaderText="User" DataField="User" HeaderStyle-HorizontalAlign="Left" />
                      <%--  <asp:BoundField HeaderText="Status" DataField="Status" HeaderStyle-HorizontalAlign="Left" />--%>
                        <asp:TemplateField HeaderText="Status" HeaderStyle-HorizontalAlign="Left">
                            <ItemTemplate>
                                <asp:Label ID="lblStatus" runat="server" Text='<%#Eval("Status") %>'></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:BoundField HeaderText="Comments" DataField="Comments" HeaderStyle-HorizontalAlign="Left" />
                        <asp:BoundField HeaderText="Corrective Action" DataField="Actions" HeaderStyle-HorizontalAlign="Left" />
                       <%-- <asp:BoundField HeaderText ="Action Date" DataField="ActionDate" HeaderStyle-HorizontalAlign="Left" />--%>
                         <asp:TemplateField HeaderText="Action Date" HeaderStyle-HorizontalAlign="Left">
                            <ItemTemplate>  
                                <asp:Label ID="lblActionDate" runat="server" Text='<%#Eval("ActionDate")%>'></asp:Label>
                            </ItemTemplate>
                        </asp:TemplateField>
                    </Columns>
                </asp:GridView>
            </td>
        </tr>
        <tr align="center">
        <td>
        <br/>
            <asp:Button ID="btnHome" runat="server" Text="Home" onclick="btnHome_Click" />    
            </td>
        </tr>
    </table>
</asp:Content>
