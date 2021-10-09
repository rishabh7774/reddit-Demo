package com.example.redditDemo.service;

import com.example.redditDemo.dto.SubredditDto;
import com.example.redditDemo.exceptions.SpringRedditException;
import com.example.redditDemo.mapper.SubredditMapper;
import com.example.redditDemo.model.Subreddit;
import com.example.redditDemo.repository.SubredditRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class SubredditService {
    private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubReddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No Subreddit Found For Given Id"));
        return subredditMapper.mapSubredditToDto(subreddit);
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll().stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(Collectors.toList());
    }
}
