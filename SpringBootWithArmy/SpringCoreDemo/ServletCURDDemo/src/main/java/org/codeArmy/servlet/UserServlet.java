package org.codeArmy.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.codeArmy.model.User;
import org.codeArmy.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (idParam == null || idParam.isBlank() || name == null || name.isBlank() || email == null || email.isBlank() || mobile == null || mobile.isBlank()) {

            sendJson(response, 400, "{\"message\":\"Required fields are missing\"}");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response, 400, "{\"message\":\"Invalid user ID\"}");
            return;
        }

        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);

        if (createdUser != null) {
            sendJson(response, 201, userToJson(createdUser));
        } else {
            sendJson(response, 500, "{\"message\":\"Failed to create user\"}");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idParam = request.getParameter("id");
        if (idParam == null || idParam.isBlank()) {
            List<User> users = userService.getAllUsers();
            if (users != null) {
                sendJson(response, 200, usersToJson(users));
            } else {
                sendJson(response, 500, "{\"message\":\"Failed to retrieve users\"}");
            }
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response, 400, "{\"message\":\"Invalid user ID\"}");
            return;
        }

        User user = userService.getUserById(id);

        if (user != null) {
            sendJson(response, 200, userToJson(user));
        } else {
            sendJson(response, 404, "{\"message\":\"User not found\"}");
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String mobile = request.getParameter("mobile");

        if (idParam == null || idParam.isBlank() || name == null || name.isBlank() || email == null || email.isBlank() || mobile == null || mobile.isBlank()) {

            sendJson(response, 400, "{\"message\":\"Required fields are missing\"}");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response, 400, "{\"message\":\"Invalid user ID\"}");
            return;
        }

        User user = new User(id, name, email, mobile);
        User updatedUser = userService.updateUser(user);

        if (updatedUser != null) {
            sendJson(response, 200, userToJson(updatedUser));
        } else {
            sendJson(response, 404, "{\"message\":\"User not found or update failed\"}");
        }
    }

    // DELETE USER
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String idParam = request.getParameter("id");

        if (idParam == null || idParam.isBlank()) {
            sendJson(response, 400, "{\"message\":\"User ID is required\"}");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(idParam);
        } catch (NumberFormatException e) {
            sendJson(response, 400, "{\"message\":\"Invalid user ID\"}");
            return;
        }

        // Assumes UserService has a deleteUser(int) method
        // that returns true when deletion succeeds.
        boolean deleted = userService.deleteUser(id);

        if (deleted) {
            sendJson(response, 200, "{\"message\":\"User deleted successfully\"}");
        } else {
            sendJson(response, 404, "{\"message\":\"User not found or deletion failed\"}");
        }
    }

    // SEND JSON RESPONSE
    private void sendJson(HttpServletResponse response, int status, String json) throws IOException {

        response.setStatus(status);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }

    // CONVERT SINGLE USER TO JSON
    private String userToJson(User user) {
        return "{" + "\"id\":" + user.getId() + "," + "\"name\":\"" + escapeJson(user.getName()) + "\"," + "\"email\":\"" + escapeJson(user.getEmail()) + "\"," + "\"mobile\":\"" + escapeJson(user.getMobile()) + "\"" + "}";
    }

    // CONVERT USER LIST TO JSON
    private String usersToJson(List<User> users) {
        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < users.size(); i++) {
            sb.append(userToJson(users.get(i)));

            if (i < users.size() - 1) {
                sb.append(",");
            }
        }

        sb.append("]");
        return sb.toString();
    }

    // ESCAPE SPECIAL JSON CHARACTERS
    private String escapeJson(String value) {
        if (value == null) {
            return "";
        }

        return value.replace("\\", "\\\\").replace("\"", "\\\"").replace("\n", "\\n").replace("\r", "\\r").replace("\t", "\\t");
    }
}
