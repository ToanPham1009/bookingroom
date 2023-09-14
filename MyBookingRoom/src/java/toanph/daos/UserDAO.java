/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package toanph.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import toanpg.dtos.HotelDTO;
import toanpg.dtos.RoomDTO;
import toanpg.dtos.UserDTO;
import toanpg.utils.DBUtils;

/**
 *
 * @author Gia Toan
 */
public class UserDAO {

    public UserDTO checkLogin(String id, String password) throws SQLException {
        UserDTO result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT uFullName, uRoleID, uAddress, uPhone FROM tblUsers "
                        + "WHERE uUserID=? AND uPassword=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, id);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    result = new UserDTO(id, rs.getString("uFullName"), password, rs.getString("uRoleID"),
                            rs.getString("uAddress"), rs.getString("uPhone"));
                    return result;
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<HotelDTO> getListHotel(String name, String in, String out, String roomType) throws SQLException {
        List<HotelDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT hID, hName, hAddress, hDescription "
                        + "FROM tblHotels ht join tblAreas a "
                        + "	ON ht.hAreaID = a.aID join tblRoom r "
                        + "	ON ht.hID = r.rHotelID join tblRoomType rt "
                        + "	ON r.rtID = rt.rtID "
                        + "WHERE NOT EXISTS ( "
                        + "SELECT hID, hName, hAddress, hDescription "
                        + "FROM tblHotels ht join tblRoom r "
                        + "	ON ht.hID = r.rHotelID join tblBookingDetail bd "
                        + "	ON r.rID = bd.bdRoomID join tblBooking b "
                        + "	ON bd.bdRoomID = b.bID join tblAreas a "
                        + "	ON a.aID = ht.hAreaID join tblRoomType rt "
                        + "	ON rt.rtID = r.rtID "
                        + "WHERE (b.bCheckIn<=? AND b.bCheckOut>=?) 	"
                        + ") AND (a.aName = ?) AND (rt.rtName = ?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, out);
                stm.setString(2, in);
                stm.setString(3, name);
                stm.setString(4, roomType);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String hID = rs.getString("hID");
                    String hName = rs.getString("hName");
                    String hAddress = rs.getString("hAddress");
                    String hDes = rs.getString("hDescription");

                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new HotelDTO(hID, hName, hAddress, hDes, roomType));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<UserDTO> getListUser(String name) throws SQLException {
        List<UserDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT uUserID, uFullName, uPassword, uRoleID, uAddress, uPhone "
                        + "FROM tblUsers WHERE uFullName like ?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, "%" + name + "%");
                rs = stm.executeQuery();
                while (rs.next()) {
                    String userID = rs.getString("uUserID");
                    String fullName = rs.getString("uFullName");
                    String passwrod = "***";
                    String roleID = rs.getString("uRoleID");
                    String address = rs.getString("uAddress");
                    String phone = rs.getString("uPhone");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new UserDTO(userID, fullName, passwrod, roleID, address, phone));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public List<RoomDTO> getListRoom(String hID, String rtID) throws SQLException {
        List<RoomDTO> result = null;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "SELECT rID, rPrice, rQuantity, rDescription, hName "
                        + "FROM tblRoom r join tblHotels ht "
                        + "	ON r.rHotelID = ht.hID join tblRoomType rt "
                        + "	ON rt.rtID = r.rtID "
                        + "WHERE ht.hID = ? AND rt.rtName = ? ";
                stm = conn.prepareStatement(sql);
                stm.setString(1, hID);
                stm.setString(2, rtID);
                rs = stm.executeQuery();
                while (rs.next()) {
                    String roomID = rs.getString("rID");
                    int roomPrice = Integer.parseInt(rs.getString("rPrice"));
                    int roomQuantity = Integer.parseInt(rs.getString("rQuantity"));
                    String roomDescription = rs.getString("rDescription");
                    String hName = rs.getString("hName");
                    if (result == null) {
                        result = new ArrayList<>();
                    }
                    result.add(new RoomDTO(roomID, roomPrice, roomQuantity, roomDescription, hName));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public boolean delete(String userID) throws SQLException {
        boolean result = false;
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "DELETE FROM tblUsers WHERE uUseriD=?";
                stm = conn.prepareStatement(sql);
                stm.setString(1, userID);
                result = stm.executeUpdate() > 0;
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
        return result;
    }

    public void update(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String url = "UPDATE tblUsers SET uFullName=?, uAddress=?, uPhone=? WHERE uUserID=?";
                stm = conn.prepareStatement(url);
                stm.setString(1, user.getFullName());
                stm.setString(2, user.getAddress());
                stm.setString(3, user.getPhone());
                stm.setString(4, user.getUserID());
                stm.executeUpdate();
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
    
    public void createUser(UserDTO user) throws SQLException {
        Connection conn = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            if (conn != null) {
                String sql = "INSERT INTO tblUsers(uUseRID, uFullName, uPassword, uRoleID, uAddress, uPhone) "
                        + "VALUES (?,?,?,?,?,?)";
                stm = conn.prepareStatement(sql);
                stm.setString(1, user.getUserID());
                stm.setString(2, user.getFullName());
                stm.setString(3, user.getPassword());
                stm.setString(4, user.getRoleID());
                stm.setString(5, user.getAddress());
                stm.setString(6, user.getPhone());
                stm.executeUpdate();                
            }

        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (conn != null) {
                conn.close();
            }
        }

    }
   

}
