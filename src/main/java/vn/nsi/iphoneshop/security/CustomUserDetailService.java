package vn.nsi.iphoneshop.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.nsi.iphoneshop.entity.User;
import vn.nsi.iphoneshop.exception.GeneralException;
import vn.nsi.iphoneshop.repository.UserRepository;
import vn.nsi.iphoneshop.util.Constant;

@Slf4j
@Service
@Transactional
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    /**
     *Lấy ra 1 userDetail thông qua tài username khi đăng nhập của người dùng
     *
     * hỏi anh xem tai sao yêu cầu lấy ra user detail nhưng hàm lại trả về userPrincipal
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User user = userRepository.findByUserName(s);

        if (user == null) {
            throw new GeneralException(Constant.RESPONSE.CODE.C404,
                    Constant.RESPONSE.MESSAGE.C404_USER+" với id: "+user.getId());
        }

        return new UserPrincipal(user);
    }

    /**
     * Tìm user thông qua id cửa user
     *
     */

    public UserDetails loadUserById(Long id) {

        User user = userRepository.findById(id).orElseThrow(

                () -> new GeneralException(Constant.RESPONSE.CODE.C404,
                        Constant.RESPONSE.MESSAGE.C404_USER + " với id: "+id)
        );

        return new UserPrincipal(user);
    }
}
