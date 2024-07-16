
import modelo.*;
import conexao.*;
import controle.*;
import java.util.ArrayList;
import java.sql.*;

public class App {

    public static void main(String[] args) {

        //Usuario
        UsuarioControle usuarioControle = new UsuarioControle();

        Usuario novoUsuario = new Usuario(
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );
        usuarioControle.inserirUsuario(novoUsuario);

        //Paciente
        PacienteControle pacienteControle = new PacienteControle();

        Paciente paciente = new Paciente(
                1,
                "Alergia a picada de insetos",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );
        pacienteControle.inserirPaciente(paciente);

        //Medico
        MedicoControle medicoControle = new MedicoControle();

        Medico medico = new Medico(
                1,
                "1452367",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );
        medicoControle.inserirMedico(medico);

        // Especialidade
        EspecialidadeControle especialidadeControle = new EspecialidadeControle();

        ArrayList<Especialidade> especialidades = especialidadeControle.consultarEspecialidades();

        Especialidade especialidade = new Especialidade(
                1,
                "Cardiologia"
        );
        especialidadeControle.inserirEspecialidade(especialidade);

        // Formação
        FormacaoControle fc = new FormacaoControle();

        Formacao f = new Formacao(
                1,
                medico,
                especialidade,
                Date.valueOf("2004-02-20")
        );
        fc.inserirFormacao(f);

        // Clinica
        ClinicaControle clc = new ClinicaControle();

        Clinica novaClinica = new Clinica(
                1,
                "Clinica Conceição da Malvadeza",
                "78459886"
        );
        clc.inserirClinica(novaClinica);
        
        // Consultorio
        ConsultorioControle cc = new ConsultorioControle();
        
        Consultorio consultorio = new Consultorio(
                1,
                Disponibilidade.ABERTO,
                clc.consultarClinicaCodigo(1)
        );
        cc.inserirConsultorio(consultorio);
        
        // Consulta
        ConsultaControle consultaControle = new ConsultaControle();

        Consulta novaConsulta = new Consulta(
                1,
                Date.valueOf("2024-07-19"),
                Time.valueOf("16:45:00"),
                medicoControle.consultarMedicoCodigo(1),
                pacienteControle.consultarPacienteCodigo(1),
                cc.consultarConsultorioCodigo(1)
        );
        consultaControle.inserirConsulta(novaConsulta);
        
        // Prescricao
        PrescricaoControle psc = new PrescricaoControle();
        
        Prescricao pp = new Prescricao(
                1,
                Date.valueOf("2022-12-22"),
                "Paulin Bacana",
                "Comer muita uva",
                consultaControle.consultarConsultaCodigo(1)
        );
        psc.inserirPrescricao(pp);
        
        // Laboratório
        LaboratorioControle lbc = new LaboratorioControle();
        
        Laboratorio lab = new Laboratorio(
                1,
                "Tomográfico",
                Disponibilidade.ABERTO,
                clc.consultarClinicaCodigo(1)
        );
        
        lbc.inserirLaboratorio(lab);
    }
}

/*
        //Usuario
        UsuarioControle usuarioControle = new UsuarioControle();

        Usuario novoUsuario = new Usuario(
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );

        //usuarioControle.inserirUsuario(novoUsuario);
        ArrayList<Usuario> usuarios = usuarioControle.consultarUsuarios(); // a consulta retorna um ArrayList de usuáios

        usuarioControle.imprimirUsuarios(usuarios);

        //Paciente
        PacienteControle pacienteControle = new PacienteControle();

        Paciente paciente = new Paciente(
                1,
                "Alergia a picada de insetos",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );
        //pacienteControle.inserirPaciente(paciente);

        ArrayList<Paciente> pacientes = pacienteControle.consultarPacientes();

        pacienteControle.imprimirPacientes(pacientes);

        pacienteControle.consultarPacienteCodigo(1);

        System.out.println("Ok");

        //Medico
        MedicoControle medicoControle = new MedicoControle();

        Medico medico = new Medico(
                1,
                "1452367",
                1,
                "Victor Valadão",
                "minha@senha@misteriosa",
                Date.valueOf("2010-11-05"),
                'M',
                "12345678910",
                "38410134",
                "34998789645",
                "victorvaladaotete2010@gmail.com"
        );

        //medicoControle.inserirMedico(medico);
        ArrayList<Medico> ms = medicoControle.consultarMedicos();

        medicoControle.imprimirMedicos(ms);

        System.out.println(medicoControle.consultarMedicoCodigo(1));

        System.out.println("Ok");

        // Especialidade
        EspecialidadeControle especialidadeControle = new EspecialidadeControle();

        ArrayList<Especialidade> especialidades = especialidadeControle.consultarEspecialidades();

        Especialidade especialidade = new Especialidade(
                1,
                "Cardiologia"
        );

        //especialidadeControle.inserirEspecialidade(especialidade);
        especialidadeControle.imprimirEspecialidades(especialidades);

        System.out.println(especialidadeControle.consultarEspecialidadeCodigo(1));

        Medico m = medicoControle.consultarMedicoCodigo(1);
        Especialidade e = especialidadeControle.consultarEspecialidadeCodigo(1);

        Formacao f = new Formacao(
                1,
                m,
                e,
                Date.valueOf("2004-02-20")
        );

        System.out.println("aaaa" + medicoControle.consultarMedicoCodigo(1));

        FormacaoControle fc = new FormacaoControle();

        //fc.inserirFormacao(f);
        ArrayList<Formacao> fos = fc.consultarFormacoes();

        fc.imprimirFormacoes(fos);
        System.out.println("ok");

        // Clinica
        ClinicaControle cc = new ClinicaControle();

        Clinica novoClinica = new Clinica(
                1,
                "Clinica Conceição da Malvadeza",
                "78459886"
        );

        cc.inserirClinica(novoClinica);

        ArrayList<Clinica> clinicas = cc.consultarClinicas();

        Clinica cl = cc.consultarClinicaCodigo(1);
        System.out.println(cl.toString());

        cc.imprimirClinicas(clinicas);
        
        // Consultorio
        Consultorio consultorio = new Consultorio(
                1,
                Disponibilidade.ABERTO,
                cc.consultarClinicaCodigo(1)
        );
        
        ConsultorioControle cccc = new ConsultorioControle();
        
        cccc.inserirConsultorio(consultorio);
        
        System.out.println(consultorio);
        
        
        // Consulta
        ConsultaControle consultaControle = new ConsultaControle();

        Consulta novaConsulta = new Consulta(
                1,
                Date.valueOf("2024-07-19"),
                Time.valueOf("16:45:00"),
                medicoControle.consultarMedicoCodigo(1),
                pacienteControle.consultarPacienteCodigo(1),
                consultorio
        );

        consultaControle.inserirConsulta(novaConsulta);

        ArrayList<Consulta> consulta = consultaControle.consultarConsultas();

        consultaControle.imprimirConsulta(consulta);

        System.out.println("Ok");

// Prescricao
        PrescricaoControle psc = new PrescricaoControle();
        
        Prescricao pp = new Prescricao(
                1,
                Date.valueOf("2022-12-22"),
                "Paulin Bacana",
                "Comer muita uva",
                consultaControle.consultarConsultaCodigo(1)
        );
        
        psc.inserirPrescricao(pp);
        System.out.println(pp);
 */
