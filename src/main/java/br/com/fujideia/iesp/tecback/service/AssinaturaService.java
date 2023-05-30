package br.com.fujideia.iesp.tecback.service;

import br.com.fujideia.iesp.tecback.model.Assinatura;
import br.com.fujideia.iesp.tecback.repository.AssinaturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AssinaturaService {

    private final AssinaturaRepository assinaturaRepository;

    @Autowired
    public AssinaturaService(AssinaturaRepository assinaturaRepository) {
        this.assinaturaRepository = assinaturaRepository;
    }

    public Assinatura criarAssinatura(Assinatura assinatura) {
        return assinaturaRepository.save(assinatura);
    }

    public Assinatura atualizarAssinatura(Long id, Assinatura assinaturaAtualizada) {
        Optional<Assinatura> optionalAssinatura = assinaturaRepository.findById(id);
        if (optionalAssinatura.isPresent()) {
            Assinatura assinatura = optionalAssinatura.get();
            assinatura.setNome(assinaturaAtualizada.getNome());
            assinatura.setPreco(assinaturaAtualizada.getPreco());
            return assinaturaRepository.save(assinatura);
        } else {
            throw new IllegalArgumentException("Assinatura não encontrada com o ID: " + id);
        }
    }

    public void deletarAssinatura(Long id) {
        assinaturaRepository.deleteById(id);
    }

    public List<Assinatura> listarAssinaturas() {
        return assinaturaRepository.findAll();
    }

    public Optional<Assinatura> buscarAssinaturaPorId(Long id) {
        return assinaturaRepository.findById(id);
    }
}