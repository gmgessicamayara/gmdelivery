import './styles.css';
import { ReactComponent as LinkedInIcon} from './linkedin.svg'

function Footer() {
    return (
        <footer className="main-footer">
               App desenvolvido durante a 2ª ed. do evento Semana DevSuperior 
               <div className="footer-icons">
                    <a href="https://www.linkedin.com/in/gessicamayaramendonça" target="_new">
                        <LinkedInIcon/>
                    </a>
               </div>
        </footer>
    );
}

export default Footer;